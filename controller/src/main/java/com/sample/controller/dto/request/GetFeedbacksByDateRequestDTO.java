package com.sample.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class GetFeedbacksByDateRequestDTO {

    @Schema(description = "Start date(Gregorian)")
    @NotNull
    private Date from;

    @Schema(description = "End date(Gregorian)")
    @NotNull
    private Date to;
}
