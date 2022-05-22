package ru.nsu.dani.readingjournal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.dani.readingjournal.backend.Service.GenreService;
import ru.nsu.dani.readingjournal.backend.response.GenreNameInfo;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class GenreController {
    private final GenreService genreService;
    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
    @GetMapping({"/genres"})
    public ResponseEntity<?> getAllGenres(){
        List<GenreNameInfo> genresResponses = genreService.getAllGenres();
        if(genresResponses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(genresResponses,HttpStatus.OK);
    }

    /*@PostMapping({"/genre"})
    public Genre addGenre(Genre genre){
        return genreRepository.save(genre);
    }*/
}
