package com.example.backofficeproject.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("MOVIE") //
public class Movie extends Film {

    private String director;
    private String productionStudio;
}
