package com.sample.persistence.dao;

import com.sample.persistence.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryDAO extends JpaRepository<DeliveryEntity, Long> {
}
