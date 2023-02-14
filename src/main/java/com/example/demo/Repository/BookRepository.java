package com.example.demo.Repository;

import com.example.demo.Model.Book;
import com.example.demo.Repository.Common.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends BaseRepository<Book> {

    //    @Query("select b from Book b where b.title like %?1 or b.author like %?1 or b.description like %?1")
    List<Book> findAllByTitleLikeOrAuthorLikeOrDescriptionLike(String title, String author, String description);

    @Query("SELECT b FROM Book b WHERE b.extension LIKE :extension  AND (b.title LIKE :keyword OR b.author LIKE :keyword OR b.description LIKE :keyword)")
    List<Book> findByExtensionAndTitleOrAuthorOrDescription(@Param("extension")String extension, @Param("keyword")String keyword);

    List<Book> findByIdLessThan(Integer number);

    Page<Book> findByTitleLikeOrAuthorLikeOrDescriptionLike(String title, String author, String description, Pageable pageable);

    @Query(value = "SELECT b FROM Book b WHERE b.extension LIKE :extension AND (b.title LIKE :keyword OR b.author LIKE :keyword OR b.description LIKE :keyword)")
    Page<Book> findByExtensionAndTitleOrAuthorOrDescription(@Param("extension")String extension, @Param("keyword")String keyword, Pageable pageable);
}
