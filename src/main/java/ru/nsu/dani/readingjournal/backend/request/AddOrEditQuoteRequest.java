package ru.nsu.dani.readingjournal.backend.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class AddOrEditQuoteRequest {

    @NotBlank
    @Getter @Setter
    private String text;

    @NotBlank
    @Getter @Setter
    private Long bookId;
}
