package com.example.demo.Service;

import com.example.demo.Model.Book;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    @Autowired
    private BookRepository booksRepository;

    public boolean isExists(int id) {
        return booksRepository.existsById(id);
    }

    public Book findById(int id) {
        try {
            Book book = booksRepository.findById(id).get();
            return book;
        } catch (IllegalArgumentException e) {
        } catch (NoSuchElementException e) {
        }
        return null;
    }

    public List<Book> findAll(String queryString, String extension) {
        List<Book> books = null;
        if (StringUtils.hasLength(queryString) && StringUtils.hasLength(extension)) {
            books = booksRepository.findByExtensionAndTitleOrAuthorOrDescription(extension + "%", queryString + "%");
        } else if (StringUtils.hasLength(queryString) && !StringUtils.hasLength(extension)) {
            books = booksRepository.findAllByTitleLikeOrAuthorLikeOrDescriptionLike(queryString + "%", queryString + "%", queryString + "%");
        } else {
            books = booksRepository.findByIdLessThan(20);
        }

        booksRepository.flush();
        return books;
    }

    public Page<Book> findAll(Pageable pageable, String queryString, String extension) {
        Page<Book> books = null;
        if (StringUtils.hasLength(queryString) && StringUtils.hasLength(extension)) {
            books = booksRepository.findByExtensionAndTitleOrAuthorOrDescription(extension + "%", queryString + "%", pageable);
        } else if (StringUtils.hasText(queryString) && !StringUtils.hasLength(extension)) {
            books = booksRepository.findByTitleLikeOrAuthorLikeOrDescriptionLike(queryString + "%", queryString + "%", queryString + "%", pageable);
        } else {
            books = booksRepository.findAll(pageable);
        }
        booksRepository.flush();
        return books;
    }
}
