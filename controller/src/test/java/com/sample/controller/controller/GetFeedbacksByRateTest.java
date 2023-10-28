package com.sample.controller.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.controller.dto.ResponseBuilder;
import com.sample.controller.dto.response.GetFeedbacksByRateResponseDTO;
import com.sample.persistence.dao.FeedbackDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class GetFeedbacksByRateTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FeedbackDAO feedbackDAO;

    @Test
    @WithMockUser
    public void getFeedbackByRate_happyPath() throws Exception {

        //given
        GetFeedbacksByRateResponseDTO response = ResponseBuilder.getGetFeedbacksByRateResponseDTO();

        //when
        Mockito.when(feedbackDAO.findFeedbackEntitiesByRate(Mockito.any()))
                .thenReturn(ResponseBuilder.getFeedbackEntityList());

        //then
        MvcResult result = mockMvc.perform(get("/manager/feedback/get-by-rate?rate=5"))
                .andExpect(status().is(200)).andReturn();

        GetFeedbacksByRateResponseDTO responseDTO = objectMapper.readValue(result.getResponse().getContentAsString(),
                GetFeedbacksByRateResponseDTO.class);
        Assertions.assertEquals(responseDTO, response);

    }


}
