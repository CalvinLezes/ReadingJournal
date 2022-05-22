package ru.nsu.dani.readingjournal.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.dani.readingjournal.backend.entity.Quote;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote,Long> {
    List<Quote> findQuotesByBook_Title(String title);

    List<Quote> findQuotesByBook_BookId(Long bookId);
}
