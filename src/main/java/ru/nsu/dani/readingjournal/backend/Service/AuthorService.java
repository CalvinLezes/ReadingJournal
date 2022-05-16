package ru.nsu.dani.readingjournal.backend.Service;

import org.springframework.stereotype.Service;
import ru.nsu.dani.readingjournal.backend.entity.Author;
import ru.nsu.dani.readingjournal.backend.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public void addNewAuthor(Author author){
        authorRepository.save(author);
    }
}
