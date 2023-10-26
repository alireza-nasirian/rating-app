package com.sample.controller.dto.response;

import com.sample.controller.dto.general.RateDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class FeedbackDTO {

    @Schema(description = "Given rate to delivery between 1 to 5")
    private RateDTO rate;

    @Schema(description = "comment to delivery")
    private String comment;

    @Schema(description = "feedback submission date")
    private Date feedbackDate;
}
