package com.example.backofficeproject.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("MOVIE")
public class AnimeMovie extends Anime {


    private String director;
    private String productionStudio;
}
