package ru.nsu.dani.readingjournal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.dani.readingjournal.backend.Service.BookService;
import ru.nsu.dani.readingjournal.backend.entity.Book;
import ru.nsu.dani.readingjournal.backend.entity.Genre;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        if(books.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(books, HttpStatus.OK);
    }

    @GetMapping("/books/{title}")
    public ResponseEntity<Book> findBookByTitle(@RequestBody @PathVariable String title){
        Book book = bookService.findBookByTitle(title);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        bookService.addNewBook(book);
        return new ResponseEntity(book, HttpStatus.OK);
    }
}
