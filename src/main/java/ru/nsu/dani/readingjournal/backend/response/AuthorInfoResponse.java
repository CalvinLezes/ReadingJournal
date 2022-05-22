package ru.nsu.dani.readingjournal.backend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class AuthorInfoResponse {

    @NotBlank
    @Getter @Setter
    private Long authorId;

    @NotBlank
    @Getter @Setter
    private String name;

    @NotBlank
    @Getter @Setter
    private String countryName;

    @NotBlank
    @Getter @Setter
    private List<String> books;
}
