package com.docker.sample.service;


import com.docker.sample.model.User;

import java.util.List;

public interface UserService {

    void create(User user);

    List<User> findAll();
}
