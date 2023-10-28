package com.sample.persistence.service.impl;

import com.sample.common.model.general.User;
import com.sample.persistence.converter.PersistenceMapper;
import com.sample.persistence.dao.UserDAO;
import com.sample.persistence.entity.UserEntity;
import com.sample.persistence.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final PersistenceMapper mapper;

    @Transactional
    @Override
    public User findUserByUsername(String username) {
        return mapper.fromUserEntityToUser(userDAO.findUserEntitiesByUsername(username));
    }

    @Override
    public User save(User user) {
        return mapper.fromUserEntityToUser(userDAO.save(mapper.fromUserToUserEntity(user)));
    }
}
