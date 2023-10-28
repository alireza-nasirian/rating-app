package com.sample.common.model.enumeration;

import java.util.HashMap;

public enum Rate {

    FIVE_STAR(5),
    FOUR_STAR(4),
    THREE_STAR(3),
    TWO_STAR(2),
    ONE_STAR(1);
    private final Integer value;

    Rate(Integer value) {
        this.value = value;
    }

    private static HashMap<Integer, Rate> valueMap = new HashMap<>();

    static {
        for (Rate rateDTO : values()) {
            valueMap.put(rateDTO.value, rateDTO);
        }
    }

    public static Rate getByValue(Integer value) {
        return valueMap.get(value);
    }
}
