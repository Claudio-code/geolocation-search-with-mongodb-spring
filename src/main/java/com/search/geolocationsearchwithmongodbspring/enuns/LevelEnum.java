package com.search.geolocationsearchwithmongodbspring.enuns;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LevelEnum {
    JUNIOR("Junior"),
    MIDDLE("Middle"),
    SENIOR("Senior");

    public final String levelName;
}
