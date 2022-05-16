package ru.nsu.dani.readingjournal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.dani.readingjournal.backend.Service.AuthorService;
import ru.nsu.dani.readingjournal.backend.entity.Author;
import ru.nsu.dani.readingjournal.backend.entity.Book;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorService.getAllAuthors();
        if(authors.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(authors, HttpStatus.OK);
    }
}
