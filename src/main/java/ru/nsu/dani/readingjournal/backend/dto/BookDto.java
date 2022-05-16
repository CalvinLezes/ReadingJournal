package ru.nsu.dani.readingjournal.backend.dto;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nsu.dani.readingjournal.backend.entity.Book;
import ru.nsu.dani.readingjournal.backend.entity.Series;

import java.text.ParseException;
import java.util.Date;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class BookDto {

    @Autowired
    private ModelMapper modelMapper;

    private Long bookId;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private Date date;

    @Getter @Setter
    private String feedback;

    @Getter @Setter
    private Integer rating;

    @Getter @Setter
    private Integer id_in_series;

    @Getter @Setter
    private Series series;



}
