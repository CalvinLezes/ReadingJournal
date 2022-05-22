package ru.nsu.dani.readingjournal.backend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
public class BookFullInfo {

    @NotBlank
    @Getter @Setter
    private Long bookId;

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
    private List<AuthorNameInfo> authors;

    @NotBlank
    @Getter @Setter
    private List<GenreNameInfo> genres;

    @Getter @Setter
    private String seriesName;

    @Getter @Setter
    private Integer idInSeries;

}
