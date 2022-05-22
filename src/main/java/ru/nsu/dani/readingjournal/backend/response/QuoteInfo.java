package ru.nsu.dani.readingjournal.backend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
public class QuoteInfo {

    @NotBlank
    @Getter @Setter
    private Long quoteId;

    @NotBlank
    @Getter @Setter
    private String text;

    @NotBlank
    @Getter @Setter
    private Long bookId;

    @NotBlank
    @Getter @Setter
    private String bookTitle;
}
