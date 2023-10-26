package com.sample.controller.dto.general;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FeedbackDTO {

    @NotNull
    @Schema(description = "Given rate to delivery between 1 to 5")
    private RateDTO rate;

    @Schema(description = "comment to delivery")
    private String comment;
}
