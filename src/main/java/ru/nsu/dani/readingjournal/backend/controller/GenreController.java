package ru.nsu.dani.readingjournal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.dani.readingjournal.backend.Service.GenreService;
import ru.nsu.dani.readingjournal.backend.entity.Genre;
import ru.nsu.dani.readingjournal.backend.repository.GenreRepository;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping({"/genres"})
    public ResponseEntity<?> getAllGenres(){
        List<Genre> response = genreService.getAllGenres();
        return ResponseEntity.ok(response);
    }

    /*@PostMapping({"/genre"})
    public Genre addGenre(Genre genre){
        return genreRepository.save(genre);
    }*/
}
