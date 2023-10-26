package com.sample.persistence.entity;

public enum RateEntity {

    FIVE_STAR(5),
    FOUR_STAR(4),
    THREE_STAR(3),
    TWO_STAR(2),
    ONE_STAR(1);
    private final Integer value;

    RateEntity(Integer value) {
        this.value = value;
    }
}
