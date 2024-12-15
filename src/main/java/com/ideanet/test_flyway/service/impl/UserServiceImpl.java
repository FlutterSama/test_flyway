package com.ideanet.test_flyway.service.impl;

import com.ideanet.test_flyway.domain.User;
import com.ideanet.test_flyway.repository.UserRepository;
import com.ideanet.test_flyway.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User saveUser(User user) {
      return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsersByName(String username) {
        return userRepository.findByName(username);
    }
}
