package com.example.demo.Controller;

import com.example.demo.Model.Book;
import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 这里前端可以传入参数自己选择进行排序和分页
     */
    @GetMapping
    public ResponseEntity<?> findAll(Pageable pageable, String size, String queryString, String extension) {
        if (StringUtils.hasLength(size)) {
            Page<Book> booksPage = bookService.findAll(pageable, queryString, extension);
            return new ResponseEntity<Page>(booksPage, HttpStatus.OK);
        }
        List<Book> books = bookService.findAll(queryString, extension);
        return new ResponseEntity<List>(books, HttpStatus.OK);
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        if (bookService.isExists(id)) {
            Book book = bookService.findById(id);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        }
        return new ResponseEntity<String>("请求的资源不存在", HttpStatus.BAD_REQUEST);
    }

}
