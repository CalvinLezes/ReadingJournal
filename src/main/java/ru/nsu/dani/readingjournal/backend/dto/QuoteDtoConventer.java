package ru.nsu.dani.readingjournal.backend.dto;

import org.modelmapper.ModelMapper;
import ru.nsu.dani.readingjournal.backend.entity.Book;
import ru.nsu.dani.readingjournal.backend.entity.Quote;

import java.text.ParseException;

public class QuoteDtoConventer {
    private final ModelMapper modelMapper;

    public QuoteDtoConventer() {
        this.modelMapper = new ModelMapper();
    }

    public Quote convertToEntity(QuoteDto quoteDto) throws ParseException {
        return modelMapper.map(quoteDto, Quote.class);
    }
    public QuoteDto convertToDto(Quote quote) {
        return modelMapper.map(quote, QuoteDto.class);
    }
}
