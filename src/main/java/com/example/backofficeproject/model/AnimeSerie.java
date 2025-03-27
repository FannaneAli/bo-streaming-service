package com.example.backofficeproject.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@DiscriminatorValue("SERIE")
public class AnimeSerie extends Anime {

    private int currentSeason;
    private int episodeCount;
    private String status;

    @OneToMany(mappedBy = "anime")
    private List<Season> seasons;
}
