package com.example.backofficeproject.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryName name;

    @ManyToMany(mappedBy = "categories")
    private List<Film> films;

    @ManyToMany(mappedBy = "categories")
    private List<Anime> animes;




    public boolean belongsToCategory(Film film) {
        return film.getCategories().stream()
                .anyMatch(category -> category.getName().equals(this.name));
    }



    public boolean belongsToCategory(Anime anime) {
        return anime.getCategories().stream()
                .anyMatch(category -> category.getName().equals(this.name));
    }
}
