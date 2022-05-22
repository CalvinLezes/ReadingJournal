package ru.nsu.dani.readingjournal.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    @Getter @Setter
    private Country country;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "authors"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Getter @Setter
    Set<Book> books = new HashSet<>();

    public Author(String name, String surname, Country country){
        this.name = name;
        this.country = country;
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.getAuthors().add(this);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
        book.getAuthors().remove(this);
    }
}
