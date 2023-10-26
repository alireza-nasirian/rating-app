package com.sample.controller.dto.request;

import com.sample.controller.dto.general.RateDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class GetFeedbacksByRateRequestDTO {

    @Schema(description = "Rate to get feedbacks with it")
    private RateDTO rate;
}
