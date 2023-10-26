package com.sample.controller.controller;

import com.sample.controller.dto.request.SubmitFeedbackRequestDTO;
import com.sample.controller.dto.response.SubmitFeedbackResponseDTO;
import com.sample.controller.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerResource {

    private final CustomerService customerService;

    @Operation(summary = "Submit a feedback with delivery ID", responses = {
            @ApiResponse(responseCode = "200", description = "OK", content =
            @Content(schema = @Schema(implementation = SubmitFeedbackResponseDTO.class)))
    })
    @PostMapping(value = {"/feedback/submit"},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SubmitFeedbackResponseDTO submitFeedback(@Valid @RequestBody SubmitFeedbackRequestDTO request) {

        return customerService.submitFeedback(request);

    }
}
