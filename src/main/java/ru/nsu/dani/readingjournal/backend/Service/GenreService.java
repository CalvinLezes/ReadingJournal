package ru.nsu.dani.readingjournal.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.dani.readingjournal.backend.GenreNotFoundException;
import ru.nsu.dani.readingjournal.backend.entity.Genre;
import ru.nsu.dani.readingjournal.backend.repository.GenreRepository;
import ru.nsu.dani.readingjournal.backend.response.GenreNameInfo;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;
    @Autowired
    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public Genre getGenreByName(String name){
        return genreRepository.findGenreByName(name);
    }
    public List<GenreNameInfo> getAllGenres(){
        List<Genre> genres = genreRepository.findAll();
        List<GenreNameInfo> genresResponses = new ArrayList<>();
        for (Genre genre: genres) {
            genresResponses.add(new GenreNameInfo(genre.getGenreId(), genre.getName()));
        }
        return  genresResponses;
    }

    public Genre addGenre(Genre genre){
        return genreRepository.save(genre);
    }

    public void updateGenre(Genre genre){
         genreRepository.save(genre);
    }

    public Genre getGenreById(Long genreId) throws GenreNotFoundException {
        return genreRepository.findById(genreId).orElseThrow(()->new GenreNotFoundException("Genre not found with id"+ genreId));
    }
}
