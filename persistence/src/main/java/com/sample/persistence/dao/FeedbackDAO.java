package com.sample.persistence.dao;

import com.sample.persistence.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FeedbackDAO extends JpaRepository<FeedbackEntity, Long> {

    List<FeedbackEntity> findByFeedbackDateBetweenOrderByFeedbackDate(Date start, Date end);

    List<FeedbackEntity> findFeedbackEntitiesByBiker_Id(Long id);
}
