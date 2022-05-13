package ru.nsu.dani.readingjournal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.dani.readingjournal.backend.Service.AuthorService;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;
}
