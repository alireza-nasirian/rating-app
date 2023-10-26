package com.sample.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubmitFeedbackRequestDTO {

    @NotNull
    @Valid
    @Schema(description = "given feedback to delivery")
    private FeedbackDTO feedback;

    @NotBlank
    @Schema(description = "ID of Delivery")
    private String deliveryId;


}
