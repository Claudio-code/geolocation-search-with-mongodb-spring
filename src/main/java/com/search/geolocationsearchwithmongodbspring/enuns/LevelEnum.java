package com.search.geolocationsearchwithmongodbspring.enuns;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LevelEnum {
    JUNIOR("Junior"),
    MIDDLE("Middle"),
    SENIOR("Senior");

    private final String name;
}
