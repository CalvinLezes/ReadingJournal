package ru.nsu.dani.readingjournal.backend.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public class NewBookRequest {

    @NotBlank
    @Getter @Setter
    private String title;

    @NotBlank
    @Getter @Setter
    private Date readDate;

    @NotBlank
    @Getter @Setter
    private String feedback;

    @NotBlank
    @Getter @Setter
    private Integer rating;

    @NotBlank
    @Getter @Setter
    private List<Long> authorIds;

    @NotBlank
    @Getter @Setter
    private List<Long> genreIds;
}
