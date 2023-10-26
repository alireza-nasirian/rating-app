package com.sample.persistence.service;

import com.sample.common.model.general.Feedback;

public interface FeedbackService {

    Long insertFeedback(Feedback feedback, Long deliveryId);

}
