package com.sample.persistence.service;

import com.sample.common.model.enumeration.Rate;
import com.sample.common.model.request.Feedback;

import java.util.Date;
import java.util.List;

public interface FeedbackService {

    Long insertFeedback(Feedback feedback, Long deliveryId);

    List<com.sample.common.model.response.Feedback> getFeedbacksByDate(Date from, Date to);

    List<com.sample.common.model.response.Feedback> getFeedbacksByBiker(Long bikerId);

    List<com.sample.common.model.response.Feedback> getFeedbacksByRate(Rate rate);

}
