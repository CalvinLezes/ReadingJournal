package ru.nsu.dani.readingjournal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.dani.readingjournal.backend.BookNotFoundException;
import ru.nsu.dani.readingjournal.backend.Service.QuoteNotFoundException;
import ru.nsu.dani.readingjournal.backend.Service.QuoteService;
import ru.nsu.dani.readingjournal.backend.request.AddOrEditQuoteRequest;
import ru.nsu.dani.readingjournal.backend.response.QuoteInfo;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class QuoteController {

    @Autowired
    QuoteService quoteService;

    @GetMapping("/quotes")
    public ResponseEntity<?> getQuotes(){
        List<QuoteInfo> quoteInfos = quoteService.getAllQuotes();
        if(quoteInfos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(quoteInfos, HttpStatus.OK);
    }
    @GetMapping("/quotes/book/{bookId}")
    public ResponseEntity<?> getQuoteByBookId(@PathVariable Long bookId){
        List<QuoteInfo> quoteInfos = quoteService.getQuotesByBookId(bookId);
        if(quoteInfos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(quoteInfos, HttpStatus.OK);
    }
    @GetMapping("/quotes/{quoteId}")
    public ResponseEntity<?> getQuoteById(@PathVariable Long quoteId) throws QuoteNotFoundException {
        QuoteInfo quoteInfo = quoteService.getQuoteById(quoteId);
        return new ResponseEntity<>(quoteInfo, HttpStatus.OK);
    }
    @PutMapping("/quotes/{quoteId}")
    public ResponseEntity<?> editQuote(@PathVariable Long quoteId, @RequestBody AddOrEditQuoteRequest quoteRequest) throws QuoteNotFoundException, BookNotFoundException {
        quoteService.editQuote(quoteId, quoteRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/quotes")
    public ResponseEntity<?> addQuote(@RequestBody AddOrEditQuoteRequest quoteRequest) throws BookNotFoundException {
        quoteService.addNewQuote(quoteRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/quotes/{quoteId}")
    public ResponseEntity<?> deleteQuote(@PathVariable Long quoteId){
        quoteService.deleteQuote(quoteId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
