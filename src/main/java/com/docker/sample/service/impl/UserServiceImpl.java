package com.docker.sample.service.impl;

import com.docker.sample.model.User;
import com.docker.sample.repository.UserRepository;
import com.docker.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
