package com.sample.controller.converter;

import com.sample.common.model.request.SubmitFeedbackRequest;
import com.sample.controller.dto.request.SubmitFeedbackRequestDTO;
import org.mapstruct.Mapper;

@Mapper
public interface RequestResponseMapper {

    SubmitFeedbackRequest fromSubmitFeedbackRequestDTO(SubmitFeedbackRequestDTO dto);
}
