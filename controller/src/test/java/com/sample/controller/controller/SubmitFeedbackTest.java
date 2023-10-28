package com.sample.controller.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.controller.dto.RequestBuilder;
import com.sample.controller.dto.ResponseBuilder;
import com.sample.controller.dto.exception.ValidationExceptionInfoDTO;
import com.sample.controller.dto.request.SubmitFeedbackRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class SubmitFeedbackTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void submitFeedback_emptyDeliveryId() throws Exception {

        //given
        SubmitFeedbackRequestDTO request = RequestBuilder.getSubmitFeedbackRequestDTO_emptyBiker();
        ValidationExceptionInfoDTO response = ResponseBuilder.getEmptyDeliveryIdException();

        MvcResult result = mockMvc.perform(post("/customer/feedback/submit")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is(400)).andReturn();
        ValidationExceptionInfoDTO exception = objectMapper.readValue(result.getResponse().getContentAsString(),
                ValidationExceptionInfoDTO.class);
        Assertions.assertEquals(response, exception);
    }
}
