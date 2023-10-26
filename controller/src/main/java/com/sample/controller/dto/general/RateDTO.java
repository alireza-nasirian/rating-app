package com.sample.controller.dto.general;

public enum RateDTO {

    FIVE_STAR(5),
    FOUR_STAR(4),
    THREE_STAR(3),
    TWO_STAR(2),
    ONE_STAR(1);
    private final Integer value;

    RateDTO(Integer value) {
        this.value = value;
    }
}
