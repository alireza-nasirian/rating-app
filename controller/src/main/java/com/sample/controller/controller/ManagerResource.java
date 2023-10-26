package com.sample.controller.controller;

import com.sample.controller.dto.request.GetFeedbacksByBikerRequestDTO;
import com.sample.controller.dto.request.GetFeedbacksByDateRequestDTO;
import com.sample.controller.dto.request.GetFeedbacksByRateRequestDTO;
import com.sample.controller.dto.response.GetFeedbacksByBikerResponseDTO;
import com.sample.controller.dto.response.GetFeedbacksByDateResponseDTO;
import com.sample.controller.dto.response.GetFeedbacksByRateResponseDTO;
import com.sample.controller.service.ManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerResource {

    private final ManagerService managerService;

    @Operation(summary = "Get feedback between given dates sorted by feedback date", responses = {
            @ApiResponse(responseCode = "200", description = "OK", content =
            @Content(schema = @Schema(implementation = GetFeedbacksByDateResponseDTO.class)))
    })
    @PostMapping(value = {"/feedback/get-between-dates"},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GetFeedbacksByDateResponseDTO getFeedbacksByDate(@Valid @RequestBody GetFeedbacksByDateRequestDTO request) {
      return managerService.getFeedbacksByDate(request);
    }

    @Operation(summary = "Get feedbacks associated to given biker", responses = {
            @ApiResponse(responseCode = "200", description = "OK", content =
            @Content(schema = @Schema(implementation = GetFeedbacksByBikerResponseDTO.class)))
    })
    @PostMapping(value = {"/feedback/get-by-biker"},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GetFeedbacksByBikerResponseDTO getFeedbackByBiker(@Valid @RequestBody GetFeedbacksByBikerRequestDTO request) {
        return managerService.getFeedbacksByBiker(request);
    }

    @Operation(summary = "Get feedbacks associated to given rate", responses = {
            @ApiResponse(responseCode = "200", description = "OK", content =
            @Content(schema = @Schema(implementation = GetFeedbacksByRateResponseDTO.class)))
    })
    @PostMapping(value = {"/feedback/get-by-rate"},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GetFeedbacksByRateResponseDTO getFeedbacksByRate(@Valid @RequestBody GetFeedbacksByRateRequestDTO request) {
        return managerService.getFeedbacksByRate(request);
    }
}
