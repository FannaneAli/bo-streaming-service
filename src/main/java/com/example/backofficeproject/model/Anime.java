package com.example.backofficeproject.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "anime_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "animes")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//hello world
    private String title;
    private String description;
    private String coverImageUrl;
    private int duration;
    private LocalDate releaseDate;
    private double rating;


    @ElementCollection
    @CollectionTable(name = "anime_languages", joinColumns = @JoinColumn(name = "anime_id"))
    @Column(name = "language")
    private List<String> availableLanguages;

    private String shortDescription;
    private String trailerUrl;
    private String videoUrl;

    @ManyToMany
    @JoinTable(
            name = "anime_category",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;
}
