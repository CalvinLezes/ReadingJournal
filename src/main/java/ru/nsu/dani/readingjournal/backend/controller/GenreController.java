package ru.nsu.dani.readingjournal.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.nsu.dani.readingjournal.backend.entity.Genre;
import ru.nsu.dani.readingjournal.backend.repository.GenreRepository;

import java.util.List;

@Controller
public class GenreController {

    private GenreRepository genreRepository;

    @GetMapping({"/genres"})
    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    @PostMapping({"/genre"})
    public Genre addGenre(Genre genre){
        return genreRepository.save(genre);
    }
}
