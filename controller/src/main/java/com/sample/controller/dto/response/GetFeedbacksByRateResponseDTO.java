package com.sample.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class GetFeedbacksByRateResponseDTO {

    @Schema(description = "List of feedbacks associated to given rate")
    private List<FeedbackDTO> feedbacks;
}
