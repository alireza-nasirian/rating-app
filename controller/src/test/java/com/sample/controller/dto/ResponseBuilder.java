package com.sample.controller.dto;

import com.sample.controller.dto.exception.ValidationExceptionInfoDTO;
import com.sample.controller.dto.general.RateDTO;
import com.sample.controller.dto.response.FeedbackDTO;
import com.sample.controller.dto.response.GetFeedbacksByRateResponseDTO;
import com.sample.persistence.entity.FeedbackEntity;
import com.sample.persistence.entity.RateEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResponseBuilder {

    public static ValidationExceptionInfoDTO getEmptyDeliveryIdException() {
        String message = "Validation Exception";
        HashMap<String, String> errorParam = new HashMap<>();
        errorParam.put("deliveryId", "Is Empty");
        return new ValidationExceptionInfoDTO(message, errorParam);
    }

    public static GetFeedbacksByRateResponseDTO getGetFeedbacksByRateResponseDTO() {
        GetFeedbacksByRateResponseDTO dto = new GetFeedbacksByRateResponseDTO();
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setRate(RateDTO.FIVE_STAR);
        feedbackDTO.setComment("first comment");
        dto.setFeedbacks(List.of(feedbackDTO));
        return dto;
    }

    public static List<FeedbackEntity> getFeedbackEntityList() {
        FeedbackEntity feedbackEntity = new FeedbackEntity();
        feedbackEntity.setRate(RateEntity.FIVE_STAR);
        feedbackEntity.setComment("first comment");
        return List.of(feedbackEntity);
    }
}

