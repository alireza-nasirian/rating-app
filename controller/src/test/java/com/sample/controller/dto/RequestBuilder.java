package com.sample.controller.dto;

import com.sample.controller.dto.general.RateDTO;
import com.sample.controller.dto.request.FeedbackDTO;
import com.sample.controller.dto.request.SubmitFeedbackRequestDTO;

public class RequestBuilder {

    public static SubmitFeedbackRequestDTO getSubmitFeedbackRequestDTO_emptyBiker() {
        SubmitFeedbackRequestDTO dto = new SubmitFeedbackRequestDTO();
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setRate(RateDTO.FOUR_STAR);
        dto.setFeedback(feedbackDTO);
        dto.setDeliveryId("");
        return dto;
    }
}
