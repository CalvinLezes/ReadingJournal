package ru.nsu.dani.readingjournal.backend.dto;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nsu.dani.readingjournal.backend.entity.Book;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class QuoteDto {

    @Getter @Setter
    private String text;

    @Getter @Setter
    private String book;
}
