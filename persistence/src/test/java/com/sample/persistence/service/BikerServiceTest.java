package com.sample.persistence.service;

import com.sample.persistence.dao.BikerDAO;
import com.sample.persistence.entity.BikerEntity;
import com.sample.persistence.entity.FeedbackEntity;
import com.sample.persistence.entity.RateEntity;
import com.sample.persistence.service.impl.BikerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = BikerServiceImpl.class)
@AutoConfigureMockMvc
public class BikerServiceTest {

    @MockBean
    private BikerDAO bikerDAO;

    @SpyBean
    private BikerService bikerService;

    @Test
    public void testGetBikerRateById_withEmptyFeedbacks() {
        // Arrange
        Long id = 1L;
        BikerEntity bikerEntity = new BikerEntity();
        bikerEntity.setFeedbacks(new ArrayList<>());
        when(bikerDAO.getReferenceById(id)).thenReturn(bikerEntity);

        // Act
        Double result = bikerService.getBikerRateById_withOutOutliers(id);

        // Assert
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testGetBikerRateById_withNoOutliers() {
        // Arrange
        Long id = 1L;
        BikerEntity bikerEntity = new BikerEntity();
        List<FeedbackEntity> feedbacks = new ArrayList<>();
        FeedbackEntity feedback1 = new FeedbackEntity();
        feedback1.setRate(RateEntity.FOUR_STAR);
        FeedbackEntity feedback2 = new FeedbackEntity();
        feedback2.setRate(RateEntity.FIVE_STAR);
        FeedbackEntity feedback3 = new FeedbackEntity();
        feedback3.setRate(RateEntity.THREE_STAR);
        feedbacks.add(feedback1);
        feedbacks.add(feedback2);
        feedbacks.add(feedback3);
        bikerEntity.setFeedbacks(feedbacks);
        when(bikerDAO.getReferenceById(id)).thenReturn(bikerEntity);

        // Act
        Double result = bikerService.getBikerRateById_withOutOutliers(id);

        // Assert
        assertEquals(4.0, result, 0.001);
    }

    @Test
    public void testGetBikerRateById_withOutliers() {
        // Arrange
        Long id = 1L;
        BikerEntity bikerEntity = new BikerEntity();
        List<FeedbackEntity> feedbacks = new ArrayList<>();
        FeedbackEntity feedback1 = new FeedbackEntity();
        feedback1.setRate(RateEntity.FOUR_STAR);
        FeedbackEntity feedback2 = new FeedbackEntity();
        feedback2.setRate(RateEntity.FIVE_STAR);
        FeedbackEntity feedback3 = new FeedbackEntity();
        feedback3.setRate(RateEntity.FIVE_STAR);
        FeedbackEntity feedback4 = new FeedbackEntity();
        feedback4.setRate(RateEntity.FIVE_STAR);
        FeedbackEntity feedback5 = new FeedbackEntity();
        feedback5.setRate(RateEntity.ONE_STAR);
        FeedbackEntity feedback6 = new FeedbackEntity();
        feedback6.setRate(RateEntity.FIVE_STAR);
        FeedbackEntity feedback7 = new FeedbackEntity();
        feedback7.setRate(RateEntity.FOUR_STAR);

        feedbacks.add(feedback1);
        feedbacks.add(feedback2);
        feedbacks.add(feedback3);
        feedbacks.add(feedback4);
        feedbacks.add(feedback5);
        feedbacks.add(feedback6);
        feedbacks.add(feedback7);

        bikerEntity.setFeedbacks(feedbacks);
        when(bikerDAO.getReferenceById(id)).thenReturn(bikerEntity);

        // Act
        Double result = bikerService.getBikerRateById_withOutOutliers(id);

        // Assert
        assertEquals(4.666, result, 0.001);
    }
}
