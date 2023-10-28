package com.sample.core.core;

import com.sample.common.model.enumeration.Rate;
import com.sample.common.model.request.GetFeedbacksByBikerRequest;
import com.sample.common.model.request.GetFeedbacksByDateRequest;
import com.sample.common.model.request.SubmitFeedbackRequest;
import com.sample.common.model.response.Feedback;

import java.util.List;

public interface FeedbackCore {

    String submitFeedback(SubmitFeedbackRequest request);

    List<Feedback> getFeedbacksByDate(GetFeedbacksByDateRequest request);

    List<Feedback> getFeedbacksByBiker(GetFeedbacksByBikerRequest request);

    List<Feedback> getFeedbacksByRate(Rate rate);
}
