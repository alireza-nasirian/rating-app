package com.sample.persistence.dao;

import com.sample.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<Long, User> {
}
