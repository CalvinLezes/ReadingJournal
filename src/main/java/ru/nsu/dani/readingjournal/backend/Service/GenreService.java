package ru.nsu.dani.readingjournal.backend.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.nsu.dani.readingjournal.backend.entity.Genre;
import ru.nsu.dani.readingjournal.backend.repository.GenreRepository;

import java.util.List;

@Service
public class GenreService {

    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    public Genre addGenre(Genre genre){
        return genreRepository.save(genre);
    }
}
