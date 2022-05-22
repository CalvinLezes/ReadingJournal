package ru.nsu.dani.readingjournal.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.dani.readingjournal.backend.AuthorNotFoundException;
import ru.nsu.dani.readingjournal.backend.BookNotFoundException;
import ru.nsu.dani.readingjournal.backend.GenreNotFoundException;
import ru.nsu.dani.readingjournal.backend.entity.*;
import ru.nsu.dani.readingjournal.backend.repository.BookRepository;
import ru.nsu.dani.readingjournal.backend.request.NewBookRequest;
import ru.nsu.dani.readingjournal.backend.response.AuthorNameInfo;
import ru.nsu.dani.readingjournal.backend.response.BookFullInfo;
import ru.nsu.dani.readingjournal.backend.response.BookTitleInfoResponse;
import ru.nsu.dani.readingjournal.backend.response.GenreNameInfo;

import java.util.*;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final GenreService genreService;
    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService, GenreService genreService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.genreService = genreService;
    }
    public List<BookFullInfo> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        List<BookFullInfo> bookInfos = new ArrayList<>();
        for (Book book: books) {
            List<AuthorNameInfo> authorNames = new ArrayList<>();
            List<GenreNameInfo> genres = new ArrayList<>();
            for (Author author: book.getAuthors()){
                authorNames.add(new AuthorNameInfo(author.getAuthorId(),author.getName()));
            }
            for (Genre genre: book.getGenres()){
                genres.add(new GenreNameInfo(genre.getGenreId(),genre.getName()));
            }
            Series series = book.getSeries();
            String seriesName;
            if(series==null){
                seriesName = null;
            }else{
                seriesName=series.getName();
            }
            bookInfos.add(new BookFullInfo(
                    book.getBookId(),
                    book.getTitle(),
                    book.getReadDate(),
                    book.getFeedback(),
                    book.getRating(),
                    authorNames,
                    genres,
                    seriesName,
                    book.getIdInSeries()
            ));
        }
        return bookInfos;
    }
    public Book getBookById(Long bookId) throws BookNotFoundException {
        return bookRepository.findById(bookId).orElseThrow(()-> new BookNotFoundException("Book not found with id"+bookId));
    }
    public void addNewBook(NewBookRequest newBookRequest) throws GenreNotFoundException, AuthorNotFoundException {
        Set<Author> authors= new HashSet<>();
        for (Long authorId:newBookRequest.getAuthorIds()) {
            authors.add(authorService.getAuthorById(authorId));
        }
        Set<Genre> genres = new HashSet<>();
        for (Long genreId: newBookRequest.getGenreIds()){
            genres.add(genreService.getGenreById(genreId));
        }
        Book book = new Book(
                newBookRequest.getTitle(),
                newBookRequest.getReadDate(),
                newBookRequest.getRating(),
                newBookRequest.getFeedback(),
                null,
                null
                );
        Book savedBook = bookRepository.save(book);
        for (Author author: authors) {
            author.addBook(savedBook);
            authorService.updateAuthor(author);
        }
        for (Genre genre: genres){
            genre.addBook(savedBook);
            genreService.updateGenre(genre);
        }
        bookRepository.save(savedBook);
    }

    public List<BookTitleInfoResponse> getBookTitles() {
        List<Book> books = bookRepository.findAll();
        List<BookTitleInfoResponse> bookTitles = new ArrayList<>();
        for (Book book: books) {
            bookTitles.add(new BookTitleInfoResponse(book.getBookId(), book.getTitle()));
        }
        return bookTitles;
    }

    public void deleteBook(Long bookId) throws BookNotFoundException {
        Book book = bookRepository.findById(bookId).orElseThrow(()->new BookNotFoundException("Book not found with id"+bookId));
        Set<Author> authors = new HashSet<>(book.getAuthors());
        for (Author author: authors) {
            author.removeBook(book);
        }
        Set<Genre> genres = new HashSet<>(book.getGenres());
        for (Genre genre: genres) {
            genre.removeBook(book);
        }
        bookRepository.deleteById(bookId);
    }

    public BookFullInfo getBookInfoById(Long bookId) throws BookNotFoundException {
        Book book = getBookById(bookId);
        List<AuthorNameInfo> authorNames = new ArrayList<>();
        List<GenreNameInfo> genres = new ArrayList<>();
        for (Author author: book.getAuthors()){
            authorNames.add(new AuthorNameInfo(author.getAuthorId(),author.getName()));
        }
        for (Genre genre: book.getGenres()){
            genres.add(new GenreNameInfo(genre.getGenreId(),genre.getName()));
        }
        Series series = book.getSeries();
        String seriesName;
        if(series==null){
            seriesName = null;
        }else{
            seriesName=series.getName();
        }
        return new BookFullInfo(
                book.getBookId(),
                book.getTitle(),
                book.getReadDate(),
                book.getFeedback(),
                book.getRating(),
                authorNames,
                genres,
                seriesName,
                book.getIdInSeries()
        );
    }

    public void editBook(Long bookId, NewBookRequest newBookRequest) throws BookNotFoundException, AuthorNotFoundException, GenreNotFoundException {
        Book book = getBookById(bookId);
        Set<Author> authors= new HashSet<>();
        for (Long authorId:newBookRequest.getAuthorIds()) {
            Author author = authorService.getAuthorById(authorId);
            author.addBook(book);
            authors.add(author);
        }
        Set<Genre> genres = new HashSet<>();
        for (Long genreId: newBookRequest.getGenreIds()){
            Genre genre = genreService.getGenreById(genreId);
            genre.addBook(book);
            genres.add(genre);
        }
        book.setTitle(newBookRequest.getTitle());
        book.setReadDate(newBookRequest.getReadDate());
        book.setRating(newBookRequest.getRating());
        book.setFeedback(newBookRequest.getFeedback());
        book.setAuthors(authors);
        book.setGenres(genres);
        bookRepository.save(book);
    }
}
