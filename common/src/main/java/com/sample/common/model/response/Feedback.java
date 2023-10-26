package com.sample.common.model.response;

import com.sample.common.model.enumeration.Rate;
import lombok.Data;

import java.util.Date;

@Data
public class Feedback {

    private Rate rate;
    private String comment;
    private Date feedbackDate;

}
