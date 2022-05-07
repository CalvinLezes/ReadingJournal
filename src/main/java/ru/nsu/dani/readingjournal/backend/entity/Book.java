package ru.nsu.dani.readingjournal.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "title")
    @NotBlank
    @Getter @Setter
    private String title;

    @Column(name = "read_date")
    @Getter @Setter
    private Date readDate;

    @Column(name = "rating")
    @NotBlank
    @Getter @Setter
    private Integer rating;

    @Column(name = "feedback")
    @Getter @Setter
    private String feedback;

    @Column(name = "id_in_series")
    @Getter @Setter
    private Integer idInSeries;

    @ManyToOne
    @JoinColumn(name = "series_id", nullable = false)
    @Getter @Setter
    private Series series;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @Getter @Setter
    Set<Author> authors = new HashSet<>();

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "books"
    )
    @Getter @Setter
    Set<Genre> genres = new HashSet<>();

    public Book(String title,Date date, Integer rating, String feedback, Series series, Integer id_series){
        this.title = title;
        this.readDate = date;
        this.rating = rating;
        this.feedback = feedback;
        this.series = series;
        this.idInSeries = id_series;
    }
}
