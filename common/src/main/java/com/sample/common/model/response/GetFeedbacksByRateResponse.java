package com.sample.common.model.response;

import lombok.Data;

import java.util.List;

@Data
public class GetFeedbacksByRateResponse {

    private List<Feedback> feedbacks;
}
