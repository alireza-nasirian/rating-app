package com.sample.controller.dto.general;

import java.util.HashMap;

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

    private static HashMap<Integer, RateDTO> valueMap = new HashMap<>();

    static {
        for (RateDTO rateDTO : values()) {
            valueMap.put(rateDTO.value, rateDTO);
        }
    }

    public static RateDTO getByValue(Integer value) {
        return valueMap.get(value);
    }
}
