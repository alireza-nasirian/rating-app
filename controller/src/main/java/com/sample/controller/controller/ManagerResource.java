package com.sample.controller.controller;

import com.sample.controller.dto.request.GetFeedbacksByDateRequestDTO;
import com.sample.controller.dto.response.GetFeedbacksByBikerResponseDTO;
import com.sample.controller.dto.response.GetFeedbacksByDateResponseDTO;
import com.sample.controller.dto.response.GetFeedbacksByRateResponseDTO;
import com.sample.controller.service.ManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = {"/feedback/get-by-biker"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GetFeedbacksByBikerResponseDTO getFeedbackByBiker(@RequestParam(name = "bikerId") @NotBlank String bikerId) {
        return managerService.getFeedbacksByBiker(bikerId);
    }

    @Operation(summary = "Get feedbacks associated to given rate", responses = {
            @ApiResponse(responseCode = "200", description = "OK", content =
            @Content(schema = @Schema(implementation = GetFeedbacksByRateResponseDTO.class)))
    })
    @GetMapping(value = {"/feedback/get-by-rate"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GetFeedbacksByRateResponseDTO getFeedbacksByRate(@RequestParam @NotNull @Min(0) @Max(5) Integer rate) {
        return managerService.getFeedbacksByRate(rate);
    }
}
