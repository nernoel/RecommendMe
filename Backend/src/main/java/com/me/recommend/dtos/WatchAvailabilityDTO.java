package com.me.recommend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WatchAvailabilityDTO {

    private String streamingPlatform; // Netflix, Hulu, Prime etc.

    private String watchUrl;
}
