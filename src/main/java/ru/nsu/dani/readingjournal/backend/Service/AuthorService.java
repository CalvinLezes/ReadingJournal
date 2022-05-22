package ru.nsu.dani.readingjournal.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.dani.readingjournal.backend.AuthorNotFoundException;
import ru.nsu.dani.readingjournal.backend.entity.Author;
import ru.nsu.dani.readingjournal.backend.entity.Book;
import ru.nsu.dani.readingjournal.backend.repository.AuthorRepository;
import ru.nsu.dani.readingjournal.backend.response.AuthorNameInfo;
import ru.nsu.dani.readingjournal.backend.response.AuthorInfoResponse;
import ru.nsu.dani.readingjournal.backend.response.AuthorNameResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<AuthorNameInfo> getAllAuthors(){
        List<Author> authors = authorRepository.findAll();
        List<AuthorNameInfo> authorInfos  = new ArrayList<>();
        for (Author author: authors) {
            authorInfos.add(new AuthorNameInfo(author.getAuthorId(), author.getName()));
        }
        return authorInfos;
    }

    public void addNewAuthor(Author author){
        authorRepository.save(author);
    }

    public Author getAuthorByName(String name){
        return authorRepository.findAuthorByName(name);
    }
    public List<AuthorNameResponse> getAuthorNames() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorNameResponse> authorNames = new ArrayList<>();
        for (Author author: authors) {
            authorNames.add(new AuthorNameResponse(author.getAuthorId(), author.getName()));
        }
        return authorNames;
    }

    public void updateAuthor(Author author){
        authorRepository.save(author);
    }

    public Author getAuthorById(Long authorId) throws AuthorNotFoundException {
        return authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("Author Not Found with id" + authorId));
    }
        public AuthorInfoResponse getAuthorByIdWithBookTitles(Long authorId) throws AuthorNotFoundException {
        Author author = authorRepository.findById(authorId).orElseThrow(()-> new AuthorNotFoundException("Author Not Found with id"+authorId));
        List<String> books = new ArrayList<>();
        for (Book book: author.getBooks()) {
            books.add(book.getTitle());
        }
        return new AuthorInfoResponse(author.getAuthorId(),author.getName(),author.getCountry().getName(),books);
    }
}
