package ru.nsu.dani.readingjournal.backend.Service;

import org.springframework.stereotype.Service;
import ru.nsu.dani.readingjournal.backend.entity.Country;
import ru.nsu.dani.readingjournal.backend.entity.Genre;
import ru.nsu.dani.readingjournal.backend.repository.CountryRepository;
import ru.nsu.dani.readingjournal.backend.repository.GenreRepository;
import ru.nsu.dani.readingjournal.backend.response.AllCountriesResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    public List<AllCountriesResponse> getAllCountries(){
        List<Country> countries = countryRepository.findAll();
        List <AllCountriesResponse> countriesResponses = new ArrayList<>();
        for (Country country: countries) {
            countriesResponses.add(new AllCountriesResponse(country.getName()));
        }
        return countriesResponses;
    }
}
