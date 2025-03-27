package com.example.backofficeproject.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "film_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String coverImageUrl;
    private int duration;
    private LocalDate releaseDate;
    private double rating;
    private String shortDescription;
    private String trailerUrl;
    private String videoUrl;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ElementCollection
    @CollectionTable(name = "film_languages", joinColumns = @JoinColumn(name = "film_id"))
    @Column(name = "language")
    private List<String> availableLanguages;
}
