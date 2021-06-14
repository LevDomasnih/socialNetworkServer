package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entity.Users;
import com.example.socialnetwork.models.Login;
import com.example.socialnetwork.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthControllers {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/signin")
    public int signin(@RequestBody Login data) {
        boolean isLoginValid = usersRepository.
                existsByLoginAndPassword(data.getLogin(), data.getPassword());

        if (isLoginValid) {
            return 0;
        }
        return 1;
    }

    @PostMapping("/signup") // reg
    public int signup(@RequestBody Users data) {
        boolean isLoginValid = usersRepository.
                existsByLogin(data.getLogin());

        if (!isLoginValid) {
            usersRepository.save(data);
            return 0;
        }
        return 1;
    }

    @GetMapping("/users/get")
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }
}
