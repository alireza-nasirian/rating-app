package com.sample.controller.service;

import com.sample.common.model.response.Feedback;
import com.sample.common.model.response.GetFeedbacksByBikerResponse;
import com.sample.common.model.response.GetFeedbacksByDateResponse;
import com.sample.controller.converter.RequestResponseMapper;
import com.sample.controller.dto.request.GetFeedbacksByBikerRequestDTO;
import com.sample.controller.dto.request.GetFeedbacksByDateRequestDTO;
import com.sample.controller.dto.response.GetFeedbacksByBikerResponseDTO;
import com.sample.controller.dto.response.GetFeedbacksByDateResponseDTO;
import com.sample.core.core.FeedbackCore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final RequestResponseMapper mapper;
    private final FeedbackCore feedbackCore;

    public GetFeedbacksByDateResponseDTO getFeedbacksByDate(GetFeedbacksByDateRequestDTO request) {
        GetFeedbacksByDateResponse response = new GetFeedbacksByDateResponse();
        List<Feedback> feedbacks = feedbackCore.getFeedbacksByDate(mapper.fromGetFeedbacksByDateRequestDTO(request));
        response.setFeedbacks(feedbacks);
        return mapper.toGetFeedbacksByDateResponseDTO(response);
    }

    public GetFeedbacksByBikerResponseDTO getFeedbacksByBiker(GetFeedbacksByBikerRequestDTO request) {
        GetFeedbacksByBikerResponse response = new GetFeedbacksByBikerResponse();
        List<Feedback> feedbacks = feedbackCore.getFeedbacksByBiker(mapper.fromGetFeedbacksByBikerRequestDTO(request));
        response.setFeedbacks(feedbacks);
        return mapper.toGetFeedbacksByBikerResponseDTO(response);
    }
}
