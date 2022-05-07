package ru.nsu.dani.readingjournal.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nsu.dani.readingjournal.backend.entity.Author;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@Table(name = "Serieses")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_id")
    @Getter
    private Long seriesId;

    @Column(name = "name")
    @Getter @Setter
    @NotBlank
    private String name;

    @Column(name = "size")
    @NotBlank
    @Getter @Setter
    private Integer size;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @NotBlank
    @Getter @Setter
    private Author author;

    public Series(String name, Integer size, Author author){
        this.name = name;
        this.size = size;
        this.author = author;
    }
}
