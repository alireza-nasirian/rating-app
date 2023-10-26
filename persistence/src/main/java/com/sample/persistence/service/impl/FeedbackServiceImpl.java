package com.sample.persistence.service.impl;

import com.sample.common.model.request.Feedback;
import com.sample.persistence.converter.PersistenceMapper;
import com.sample.persistence.dao.DeliveryDAO;
import com.sample.persistence.dao.FeedbackDAO;
import com.sample.persistence.entity.DeliveryEntity;
import com.sample.persistence.entity.FeedbackEntity;
import com.sample.persistence.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackDAO feedbackDAO;
    private final DeliveryDAO deliveryDAO;
    private final PersistenceMapper mapper;

    @Override
    public Long insertFeedback(Feedback feedback, Long deliveryId) {
        DeliveryEntity delivery = deliveryDAO.getReferenceById(deliveryId);
        FeedbackEntity entity = mapper.toFeedbackEntity(feedback);
        entity.setDelivery(delivery);
        entity.setFeedbackDate(new Date());
        entity.setBiker(delivery.getBiker());
        FeedbackEntity savedEntity = feedbackDAO.save(entity);
        return savedEntity.getId();
    }

    @Override
    public List<com.sample.common.model.response.Feedback> getFeedbacksByDate(Date from, Date to) {
        return mapper.fromFeedbackEntityList(feedbackDAO.findByFeedbackDateBetweenOrderByFeedbackDate(from, to));
    }
}
