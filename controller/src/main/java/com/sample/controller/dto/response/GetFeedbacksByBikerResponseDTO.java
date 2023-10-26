package com.sample.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class GetFeedbacksByBikerResponseDTO {

    @Schema(description = "List of feedbacks associated to given biker")
    private List<FeedbackDTO> feedbacks;
}
