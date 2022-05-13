package ru.nsu.dani.readingjournal.backend.Service;

import org.springframework.stereotype.Service;
import ru.nsu.dani.readingjournal.backend.repository.AuthorRepository;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
}
