package com.sample.common.model.request;

import lombok.Data;

@Data
public class SubmitFeedbackRequest {

    private Feedback feedback;
    private String deliveryId;
}
