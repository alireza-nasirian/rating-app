package com.sample.persistence.dao;

import com.sample.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserEntity, Long> {
}
