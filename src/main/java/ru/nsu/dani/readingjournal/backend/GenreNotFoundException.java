package ru.nsu.dani.readingjournal.backend;

public class GenreNotFoundException extends Exception {
    public GenreNotFoundException() {
    }

    public GenreNotFoundException(String message) {
        super(message);
    }

    public GenreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenreNotFoundException(Throwable cause) {
        super(cause);
    }
}
