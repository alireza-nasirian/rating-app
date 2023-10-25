package com.sample.persistence.dao;

import com.sample.persistence.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryDAO extends JpaRepository<Long, Delivery> {
}
