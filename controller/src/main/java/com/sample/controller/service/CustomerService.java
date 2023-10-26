package com.sample.controller.service;

import com.sample.controller.converter.RequestResponseMapper;
import com.sample.controller.dto.request.SubmitFeedbackRequestDTO;
import com.sample.controller.dto.response.SubmitFeedbackResponseDTO;
import com.sample.core.core.FeedbackCore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final RequestResponseMapper mapper;
    private final FeedbackCore feedbackCore;

    public SubmitFeedbackResponseDTO submitFeedback(SubmitFeedbackRequestDTO request) {
        String feedbackId = feedbackCore.submitFeedback(mapper.fromSubmitFeedbackRequestDTO(request));
        SubmitFeedbackResponseDTO response = new SubmitFeedbackResponseDTO();
        response.setFeedbackId(feedbackId);
        return response;
    }
}
