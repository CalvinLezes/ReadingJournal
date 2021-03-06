package ru.nsu.dani.readingjournal.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.dani.readingjournal.backend.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
    Genre findGenreByName(String name);
}
