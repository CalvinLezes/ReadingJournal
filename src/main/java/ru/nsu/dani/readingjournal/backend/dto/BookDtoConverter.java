package ru.nsu.dani.readingjournal.backend.dto;

import org.modelmapper.ModelMapper;
import ru.nsu.dani.readingjournal.backend.entity.Book;

import java.text.ParseException;

public class BookDtoConverter {
    private final ModelMapper modelMapper;

    public BookDtoConverter() {
        this.modelMapper = new ModelMapper();
    }

    private Book convertToEntity(BookDto bookDto) throws ParseException {
        return modelMapper.map(bookDto, Book.class);
    }
    private BookDto convertToDto(Book book) {
        return modelMapper.map(book, BookDto.class);
    }
}
