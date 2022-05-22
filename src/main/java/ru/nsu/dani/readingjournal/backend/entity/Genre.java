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
@Table(name = "Genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "name")
    @Getter @Setter
    @NotBlank
    private String name;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Getter @Setter
    Set<Book> books = new HashSet<>();

    public Genre(String name){
        this.name = name;
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.getGenres().add(this);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
        book.getGenres().remove(this);
    }
}
