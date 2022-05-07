package ru.nsu.dani.readingjournal.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "Authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    @Getter
    private Long authorId;

    @Column(name = "name")
    @Getter @Setter
    @NotBlank
    private String name;

    @Column(name = "surname")
    @Getter @Setter
    private String surname;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    @Getter @Setter
    private Country country;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "authors"
    )
    @Getter @Setter
    Set<Book> books = new HashSet<>();

    public Author(String name, String surname, Country country){
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
