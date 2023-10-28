package com.sample.controller.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.controller.dto.ResponseBuilder;
import com.sample.controller.dto.response.GetFeedbacksByBikerResponseDTO;
import com.sample.persistence.dao.FeedbackDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class GetFeedbackByBikerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FeedbackDAO feedbackDAO;

    @Test
    public void getFeedbackByBiker_happyPath() throws Exception {

        //given
        GetFeedbacksByBikerResponseDTO response = ResponseBuilder.getGetFeedbacksByBikerResponseDTO();

        //when
        Mockito.when(feedbackDAO.findFeedbackEntitiesByBiker_Id(Mockito.any()))
                .thenReturn(ResponseBuilder.getFeedbackEntityList());

        //then
        MvcResult result = mockMvc.perform(get("/manager/feedback/get-by-biker?bikerId=MQ=="))
                .andExpect(status().is(200)).andReturn();

        GetFeedbacksByBikerResponseDTO responseDTO = objectMapper.readValue(result.getResponse().getContentAsString(),
                GetFeedbacksByBikerResponseDTO.class);
        Assertions.assertEquals(responseDTO, response);
    }
}
