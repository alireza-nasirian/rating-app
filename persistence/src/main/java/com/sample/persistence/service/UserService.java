package com.sample.persistence.service;

import com.sample.common.model.general.User;

public interface UserService {

    User findUserByUsername(String username);

    User save(User user);
}
