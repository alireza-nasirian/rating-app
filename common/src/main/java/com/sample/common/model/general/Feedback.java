package com.sample.common.model.general;

import com.sample.common.model.enumeration.Rate;
import lombok.Data;

@Data
public class Feedback {

    private Rate rate;
    private String comment;
}
