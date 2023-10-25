package com.sample.persistence.entity;

public enum Rate {

    FIVE_STAR(5),
    FOUR_STAR(4),
    THREE_STAR(3),
    TWO_STAR(2),
    ONE_STAR(1),
    ZERO_STAR(0);

    private final Integer value;

    Rate(Integer value) {
        this.value = value;
    }
}
