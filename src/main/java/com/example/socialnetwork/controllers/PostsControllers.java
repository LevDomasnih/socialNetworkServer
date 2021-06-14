package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entity.Posts;
import com.example.socialnetwork.entity.Users;
import com.example.socialnetwork.repo.PostsRepository;
import com.example.socialnetwork.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostsControllers {

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/post/add")
    public void add(@RequestBody String text) {
        Posts posts = new Posts();
        posts.setOwner(usersRepository.getById(1L));
        posts.setText(text);
        postsRepository.save(posts);
    }

    @PostMapping("/post/get")
    public List<Posts> get() {
        return postsRepository.findAll();
    }
}
