package com.sample.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GetFeedbacksByBikerRequestDTO {

    @Schema(description = "Biker ID to get feedbacks associated with him/her")
    @NotBlank
    private String bikerId;
}
