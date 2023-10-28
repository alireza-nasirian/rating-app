package com.sample.persistence.dao;

import com.sample.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long> {

    UserEntity save(UserEntity user);
    UserEntity findUserEntitiesByUsername(String username);
}
