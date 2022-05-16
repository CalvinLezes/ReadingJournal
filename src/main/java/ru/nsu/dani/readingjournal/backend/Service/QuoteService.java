package ru.nsu.dani.readingjournal.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.dani.readingjournal.backend.dto.QuoteDto;
import ru.nsu.dani.readingjournal.backend.dto.QuoteDtoConventer;
import ru.nsu.dani.readingjournal.backend.entity.Book;
import ru.nsu.dani.readingjournal.backend.entity.Genre;
import ru.nsu.dani.readingjournal.backend.entity.Quote;
import ru.nsu.dani.readingjournal.backend.repository.GenreRepository;
import ru.nsu.dani.readingjournal.backend.repository.QuoteRepository;

import java.text.ParseException;
import java.util.List;

@Service
public class QuoteService {
    private QuoteRepository quoteRepository;
    @Autowired
    BookService bookService;

    public QuoteService(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> getAllQuotes(){
        return quoteRepository.findAll();
    }

    public Quote addNewQuote(QuoteDto quotedto) {
        Book book = bookService.findBookByTitle(quotedto.getBook());
        Quote quote = new Quote(quotedto.getText(),book);
        return quoteRepository.save(quote);
    }

    public List<Quote> findQuotesByBookTitle(String title){
        return quoteRepository.findQuotesByBook_Title(title);
    }
}
