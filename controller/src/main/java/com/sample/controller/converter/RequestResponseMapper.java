package com.sample.controller.converter;

import com.sample.common.model.request.GetFeedbacksByBikerRequest;
import com.sample.common.model.request.GetFeedbacksByDateRequest;
import com.sample.common.model.request.SubmitFeedbackRequest;
import com.sample.common.model.response.GetFeedbacksByBikerResponse;
import com.sample.common.model.response.GetFeedbacksByDateResponse;
import com.sample.controller.dto.request.GetFeedbacksByBikerRequestDTO;
import com.sample.controller.dto.request.GetFeedbacksByDateRequestDTO;
import com.sample.controller.dto.request.SubmitFeedbackRequestDTO;
import com.sample.controller.dto.response.GetFeedbacksByBikerResponseDTO;
import com.sample.controller.dto.response.GetFeedbacksByDateResponseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface RequestResponseMapper {

    SubmitFeedbackRequest fromSubmitFeedbackRequestDTO(SubmitFeedbackRequestDTO dto);

    GetFeedbacksByDateRequest fromGetFeedbacksByDateRequestDTO(GetFeedbacksByDateRequestDTO dto);

    GetFeedbacksByDateResponseDTO toGetFeedbacksByDateResponseDTO(GetFeedbacksByDateResponse response);

    GetFeedbacksByBikerRequest fromGetFeedbacksByBikerRequestDTO(GetFeedbacksByBikerRequestDTO dto);

    GetFeedbacksByBikerResponseDTO toGetFeedbacksByBikerResponseDTO(GetFeedbacksByBikerResponse response);
}
