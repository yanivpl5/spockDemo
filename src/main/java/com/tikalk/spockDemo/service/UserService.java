package com.tikalk.spockDemo.service;

import com.tikalk.spockDemo.domain.User;
import com.tikalk.spockDemo.repository.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public UserService() {
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    public void close() {

    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
