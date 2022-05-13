package ru.nsu.dani.readingjournal.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.dani.readingjournal.backend.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
