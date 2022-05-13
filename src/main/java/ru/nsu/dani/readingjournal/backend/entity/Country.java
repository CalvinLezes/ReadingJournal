package ru.nsu.dani.readingjournal.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "Countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    @Getter
    private Long countryId;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    public Country(String name){
        this.name = name;
    }
}
