package ru.nsu.dani.readingjournal.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.dani.readingjournal.backend.BookNotFoundException;
import ru.nsu.dani.readingjournal.backend.request.AddOrEditQuoteRequest;
import ru.nsu.dani.readingjournal.backend.entity.Book;
import ru.nsu.dani.readingjournal.backend.entity.Quote;
import ru.nsu.dani.readingjournal.backend.repository.QuoteRepository;
import ru.nsu.dani.readingjournal.backend.response.QuoteInfo;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteService {


    private final QuoteRepository quoteRepository;
    private final BookService bookService;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository, BookService bookService) {
        this.quoteRepository = quoteRepository;
        this.bookService = bookService;
    }

    public List<QuoteInfo> getAllQuotes(){
        List<Quote> quotes = quoteRepository.findAll();
        List<QuoteInfo> quoteInfos = new ArrayList<>();
        for (Quote quote: quotes) {
            quoteInfos.add(new QuoteInfo(quote.getQuoteId(),quote.getText(),quote.getBook().getBookId(),quote.getBook().getTitle()));
        }
        return quoteInfos;
    }

    public List<QuoteInfo> getQuotesByBookId(Long bookId){
        List<Quote> quotes = quoteRepository.findQuotesByBook_BookId(bookId);
        List<QuoteInfo> quoteInfo = new ArrayList<>();
        for (Quote quote: quotes) {
            quoteInfo.add(new QuoteInfo(quote.getQuoteId(),quote.getText(),quote.getBook().getBookId(),quote.getBook().getTitle()));
        }
        return quoteInfo;
    }

    public void addNewQuote(AddOrEditQuoteRequest quoteRequest) throws BookNotFoundException {
        Book book = bookService.getBookById(quoteRequest.getBookId());
        Quote quote = new Quote(quoteRequest.getText(),book);
        quoteRepository.save(quote);
    }

    public List<Quote> findQuotesByBookTitle(String title){
        return quoteRepository.findQuotesByBook_Title(title);
    }

    public QuoteInfo getQuoteById(Long quoteId) throws QuoteNotFoundException {
        Quote quote = quoteRepository.findById(quoteId).orElseThrow(() -> new QuoteNotFoundException("Quote Not Found with Id "+quoteId));
        return new QuoteInfo(quote.getQuoteId(),quote.getText(),quote.getBook().getBookId(), quote.getBook().getTitle());
    }

    public void editQuote(Long quoteId, AddOrEditQuoteRequest quoteRequest) throws QuoteNotFoundException, BookNotFoundException {
        Quote quote = quoteRepository.findById(quoteId).orElseThrow(() -> new QuoteNotFoundException("Quote Not Found with Id"+quoteId));
        Book book = bookService.getBookById(quoteRequest.getBookId());
        quote.setBook(book);
        quote.setText(quoteRequest.getText());
        quoteRepository.save(quote);
    }

    public void deleteQuote(Long quoteId) {
        quoteRepository.deleteById(quoteId);
    }
}
