package com.sample.persistence.dao;

import com.sample.persistence.entity.BikerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikerDAO extends JpaRepository<BikerEntity, Long> {
}
