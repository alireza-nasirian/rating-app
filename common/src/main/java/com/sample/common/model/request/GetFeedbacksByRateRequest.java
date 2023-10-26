package com.sample.common.model.request;

import com.sample.common.model.enumeration.Rate;
import lombok.Data;

@Data
public class GetFeedbacksByRateRequest {

    private Rate rate;
}
