package com.sample.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GetFeedbacksByBikerRequestDTO {

    @NotBlank
    private String bikerId;
}
