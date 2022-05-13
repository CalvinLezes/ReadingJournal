package ru.nsu.dani.readingjournal.backend.Service;

import org.springframework.stereotype.Service;
import ru.nsu.dani.readingjournal.backend.entity.Country;
import ru.nsu.dani.readingjournal.backend.entity.Genre;
import ru.nsu.dani.readingjournal.backend.repository.CountryRepository;
import ru.nsu.dani.readingjournal.backend.repository.GenreRepository;

import java.util.List;

@Service
public class CountryService {
    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }
}
