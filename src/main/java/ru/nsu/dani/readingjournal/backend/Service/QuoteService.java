package ru.nsu.dani.readingjournal.backend.Service;

import org.springframework.stereotype.Service;
import ru.nsu.dani.readingjournal.backend.entity.Genre;
import ru.nsu.dani.readingjournal.backend.entity.Quote;
import ru.nsu.dani.readingjournal.backend.repository.GenreRepository;
import ru.nsu.dani.readingjournal.backend.repository.QuoteRepository;

import java.util.List;

@Service
public class QuoteService {
    private QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> getAllQuotes(){
        return quoteRepository.findAll();
    }
}
