package ru.nsu.dani.readingjournal.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@Table(name = "Quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quote_id")
    private Long quoteId;

    @Column(name = "text")
    @NotBlank
    private String text;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @NotBlank
    @Getter @Setter
    private Book book;

    public Quote(String text, Book book){
        this.text = text;
        this.book = book;
    }
}
