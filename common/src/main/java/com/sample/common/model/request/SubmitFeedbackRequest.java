package com.sample.common.model.request;

import com.sample.common.model.general.Feedback;
import lombok.Data;

@Data
public class SubmitFeedbackRequest {

    private Feedback feedback;
    private String deliveryId;
}
