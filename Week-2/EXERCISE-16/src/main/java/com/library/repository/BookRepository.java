package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Find book by title
    Optional<Book> findByTitle(String title);

    // Find books by author
    List<Book> findByAuthor(String author);

    // Find book by ISBN
    Optional<Book> findByIsbn(String isbn);

    // Find books by publication year
    List<Book> findByPublicationYear(Integer year);

    // Custom query to find books with available copies greater than zero
    @Query("SELECT b FROM Book b WHERE b.availableCopies > 0")
    List<Book> findAvailableBooks();

    // Custom query to find books by title pattern
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:titlePattern%")
    List<Book> findByTitlePattern(@Param("titlePattern") String titlePattern);

    // Custom query to find books by author and publication year
    @Query("SELECT b FROM Book b WHERE b.author = :author AND b.publicationYear = :year")
    List<Book> findByAuthorAndYear(@Param("author") String author, @Param("year") Integer year);
}
