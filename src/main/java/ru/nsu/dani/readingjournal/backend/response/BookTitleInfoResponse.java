package ru.nsu.dani.readingjournal.backend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@AllArgsConstructor
@NoArgsConstructor
public class BookTitleInfoResponse {

    @NotBlank
    @Getter @Setter
    private Long bookId;

    @NotBlank
    @Getter @Setter
    private String title;
}
