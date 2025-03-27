package com.example.backofficeproject.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@DiscriminatorValue("SERIE")
public class Serie extends Film {

    private int currentSeason;
    private int episodeCount;
    private String status;

    @OneToMany(mappedBy = "serie")
    private List<Season> seasons;
}
