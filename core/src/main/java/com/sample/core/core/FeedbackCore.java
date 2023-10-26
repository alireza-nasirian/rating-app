package com.sample.core.core;

import com.sample.common.model.request.GetFeedbacksByDateRequest;
import com.sample.common.model.request.SubmitFeedbackRequest;
import com.sample.common.model.response.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FeedbackCore {

    String submitFeedback(SubmitFeedbackRequest request);

    List<Feedback> getFeedbacksByDate(GetFeedbacksByDateRequest request);
}
