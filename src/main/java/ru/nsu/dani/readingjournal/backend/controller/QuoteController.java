package ru.nsu.dani.readingjournal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.dani.readingjournal.backend.Service.QuoteService;
import ru.nsu.dani.readingjournal.backend.dto.QuoteDto;
import ru.nsu.dani.readingjournal.backend.entity.Author;
import ru.nsu.dani.readingjournal.backend.entity.Book;
import ru.nsu.dani.readingjournal.backend.entity.Quote;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class QuoteController {

    @Autowired
    QuoteService quoteService;

    @GetMapping("/quotes")
    public ResponseEntity<List<Quote>> getQuotes(){
        List<Quote> quotes = quoteService.getAllQuotes();
        if(quotes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(quotes, HttpStatus.OK);
    }

    @PostMapping("/quotes")
    public ResponseEntity<?> addQuote(@RequestBody QuoteDto quotedto) {
        Quote quote = quoteService.addNewQuote(quotedto);
        return ResponseEntity.ok(quote);
    }
}
