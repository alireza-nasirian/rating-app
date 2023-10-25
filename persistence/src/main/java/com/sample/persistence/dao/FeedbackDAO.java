package com.sample.persistence.dao;

import com.sample.persistence.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackDAO extends JpaRepository<Long, Feedback> {
}
