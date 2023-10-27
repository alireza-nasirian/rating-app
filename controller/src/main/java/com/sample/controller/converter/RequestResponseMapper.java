package com.sample.controller.converter;

import com.sample.common.model.exception.ErrorCode;
import com.sample.common.model.request.GetFeedbacksByBikerRequest;
import com.sample.common.model.request.GetFeedbacksByDateRequest;
import com.sample.common.model.request.GetFeedbacksByRateRequest;
import com.sample.common.model.request.SubmitFeedbackRequest;
import com.sample.common.model.response.GetFeedbacksByBikerResponse;
import com.sample.common.model.response.GetFeedbacksByDateResponse;
import com.sample.common.model.response.GetFeedbacksByRateResponse;
import com.sample.controller.dto.exception.ErrorCodeDTO;
import com.sample.controller.dto.request.GetFeedbacksByBikerRequestDTO;
import com.sample.controller.dto.request.GetFeedbacksByDateRequestDTO;
import com.sample.controller.dto.request.GetFeedbacksByRateRequestDTO;
import com.sample.controller.dto.request.SubmitFeedbackRequestDTO;
import com.sample.controller.dto.response.GetFeedbacksByBikerResponseDTO;
import com.sample.controller.dto.response.GetFeedbacksByDateResponseDTO;
import com.sample.controller.dto.response.GetFeedbacksByRateResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestResponseMapper {

    SubmitFeedbackRequest fromSubmitFeedbackRequestDTO(SubmitFeedbackRequestDTO dto);

    GetFeedbacksByDateRequest fromGetFeedbacksByDateRequestDTO(GetFeedbacksByDateRequestDTO dto);

    GetFeedbacksByDateResponseDTO toGetFeedbacksByDateResponseDTO(GetFeedbacksByDateResponse response);

    GetFeedbacksByBikerRequest fromGetFeedbacksByBikerRequestDTO(GetFeedbacksByBikerRequestDTO dto);

    GetFeedbacksByBikerResponseDTO toGetFeedbacksByBikerResponseDTO(GetFeedbacksByBikerResponse response);

    GetFeedbacksByRateRequest fromGetFeedbacksByRateRequestDTO(GetFeedbacksByRateRequestDTO dto);

    GetFeedbacksByRateResponseDTO toGetFeedbacksByRateResponseDTO(GetFeedbacksByRateResponse response);

    ErrorCodeDTO toErrorCodeDTO(ErrorCode errorCode);
}
