package com.sample.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class GetFeedbacksByDateResponseDTO {

    @Schema(description = "List of feedbacks between given dates")
    private List<FeedbackDTO> feedbacks;
}
