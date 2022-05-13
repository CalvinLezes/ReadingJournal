package ru.nsu.dani.readingjournal.backend.Service;

import org.springframework.stereotype.Service;
import ru.nsu.dani.readingjournal.backend.entity.Book;
import ru.nsu.dani.readingjournal.backend.entity.Country;
import ru.nsu.dani.readingjournal.backend.repository.BookRepository;
import ru.nsu.dani.readingjournal.backend.repository.CountryRepository;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
