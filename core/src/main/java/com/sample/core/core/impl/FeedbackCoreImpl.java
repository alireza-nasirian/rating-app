package com.sample.core.core.impl;

import com.sample.common.model.request.GetFeedbacksByDateRequest;
import com.sample.common.model.request.SubmitFeedbackRequest;
import com.sample.common.model.response.Feedback;
import com.sample.core.core.FeedbackCore;
import com.sample.core.util.Cryptor;
import com.sample.persistence.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackCoreImpl implements FeedbackCore {

    private final Cryptor cryptor;
    private final FeedbackService feedbackService;

    @Override
    public String submitFeedback(SubmitFeedbackRequest request) {
        Long id = cryptor.decrypt(request.getDeliveryId());
        Long savedId = feedbackService.insertFeedback(request.getFeedback(), id);
        return cryptor.encrypt(savedId);
    }

    @Override
    public List<Feedback> getFeedbacksByDate(GetFeedbacksByDateRequest request) {
        return feedbackService.getFeedbacksByDate(request.getFrom(), request.getTo());
    }
}
