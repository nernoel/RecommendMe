package com.me.recommend.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
public class MovieDTO {

    private String title;

    private LocalDate releaseDate;

    private String posterUrl;

    private String category;

    private List<WatchAvailabilityDTO> watchAvailabilities;

    public String getTitle() {
        return title;
    }
}
