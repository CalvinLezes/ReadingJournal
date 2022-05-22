package ru.nsu.dani.readingjournal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.dani.readingjournal.backend.AuthorNotFoundException;
import ru.nsu.dani.readingjournal.backend.Service.AuthorService;
import ru.nsu.dani.readingjournal.backend.response.AuthorNameInfo;
import ru.nsu.dani.readingjournal.backend.response.AuthorInfoResponse;
import ru.nsu.dani.readingjournal.backend.response.AuthorNameResponse;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<?> getAllAuthors(){
        List<AuthorNameInfo> authorInfos = authorService.getAllAuthors();
        if(authorInfos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(authorInfos, HttpStatus.OK);
    }

    @GetMapping("authors/{authorId}")
    public ResponseEntity<?> getAuthorById(@PathVariable Long authorId) throws AuthorNotFoundException {
        AuthorInfoResponse authorInfo = authorService.getAuthorByIdWithBookTitles(authorId);
        return new ResponseEntity<>(authorInfo, HttpStatus.OK);
    }
    @GetMapping("authors/names")
    public ResponseEntity<?> getAuthorNames(){
        List<AuthorNameResponse> authorNames = authorService.getAuthorNames();
        if(authorNames.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(authorNames, HttpStatus.OK);
    }
}
