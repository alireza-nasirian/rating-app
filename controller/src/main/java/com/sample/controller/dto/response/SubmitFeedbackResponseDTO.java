package com.sample.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SubmitFeedbackResponseDTO {

    @Schema(description = "ID of submitted feedback")
    private String FeedbackId;
}
