package com.sample.persistence.entity;

public enum RateEntity {

    ONE_STAR(1),
    TWO_STAR(2),
    THREE_STAR(3),
    FOUR_STAR(4),
    FIVE_STAR(5);
;
    private final Integer value;

    RateEntity(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
