package com.ideanet.test_flyway.service;

import com.ideanet.test_flyway.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    List<User> getUsersByName(String username);
}
