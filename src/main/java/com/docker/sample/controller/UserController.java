package com.docker.sample.controller;

import com.docker.sample.model.User;
import com.docker.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody User user) {
        this.userService.create(user);
    }

    @GetMapping
    public ResponseEntity<?> retrieveAll() {
        List<User> all = this.userService.findAll();
        all.add(new User(1L, "Custom Hardcode User"));
        return ResponseEntity.ok(all);
    }
}
