package ru.nsu.dani.readingjournal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.dani.readingjournal.backend.Service.CountryService;
import ru.nsu.dani.readingjournal.backend.entity.Country;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getCountries(){
        return countryService.getAllCountries();
    }
}
