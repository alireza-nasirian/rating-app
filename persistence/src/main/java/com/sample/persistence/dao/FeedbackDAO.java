package com.sample.persistence.dao;

import com.sample.persistence.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackDAO extends JpaRepository<FeedbackEntity, Long> {
}
