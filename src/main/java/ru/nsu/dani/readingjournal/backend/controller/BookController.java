package ru.nsu.dani.readingjournal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.dani.readingjournal.backend.AuthorNotFoundException;
import ru.nsu.dani.readingjournal.backend.BookNotFoundException;
import ru.nsu.dani.readingjournal.backend.GenreNotFoundException;
import ru.nsu.dani.readingjournal.backend.Service.BookService;
import ru.nsu.dani.readingjournal.backend.request.NewBookRequest;
import ru.nsu.dani.readingjournal.backend.response.BookFullInfo;
import ru.nsu.dani.readingjournal.backend.response.BookTitleInfoResponse;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks(){
        List<BookFullInfo> bookInfos = bookService.getAllBooks();
        if(bookInfos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookInfos, HttpStatus.OK);
    }

    @GetMapping("/books/titles")
    public ResponseEntity<?> getBookTitles(){
        List<BookTitleInfoResponse> bookTitles = bookService.getBookTitles();
        if(bookTitles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookTitles, HttpStatus.OK);
    }
    @GetMapping("/books/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId) throws BookNotFoundException {
        BookFullInfo bookFullInfo = bookService.getBookInfoById(bookId);
        return new ResponseEntity<>(bookFullInfo,HttpStatus.OK);
    }
    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody NewBookRequest newBookRequest) throws AuthorNotFoundException, GenreNotFoundException {
        bookService.addNewBook(newBookRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<?> editBook(@PathVariable Long bookId, @RequestBody NewBookRequest newBookRequest) throws AuthorNotFoundException, GenreNotFoundException, BookNotFoundException {
        bookService.editBook(bookId,newBookRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId) throws BookNotFoundException {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
