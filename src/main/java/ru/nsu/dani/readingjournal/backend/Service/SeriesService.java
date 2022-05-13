package ru.nsu.dani.readingjournal.backend.Service;

import org.springframework.stereotype.Service;
import ru.nsu.dani.readingjournal.backend.entity.Genre;
import ru.nsu.dani.readingjournal.backend.entity.Series;
import ru.nsu.dani.readingjournal.backend.repository.GenreRepository;
import ru.nsu.dani.readingjournal.backend.repository.SeriesRepository;

import java.util.List;

@Service
public class SeriesService {
    private SeriesRepository seriesRepository;

    public SeriesService(SeriesRepository seriesRepository){
        this.seriesRepository = seriesRepository;
    }

    public List<Series> getAllSerieses(){
        return seriesRepository.findAll();
    }
}
