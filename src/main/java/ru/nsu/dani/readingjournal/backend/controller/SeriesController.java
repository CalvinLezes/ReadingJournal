package ru.nsu.dani.readingjournal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.dani.readingjournal.backend.Service.SeriesService;

@RestController
@RequestMapping("/api/")
public class SeriesController {

    @Autowired
    SeriesService seriesService;
}
