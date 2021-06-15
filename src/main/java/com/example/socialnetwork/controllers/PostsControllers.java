package com.example.socialnetwork.controllers;

import com.example.socialnetwork.entity.Followed;
import com.example.socialnetwork.entity.Posts;
import com.example.socialnetwork.models.PostsRequest;
import com.example.socialnetwork.repo.FollowedRepository;
import com.example.socialnetwork.repo.PostsRepository;
import com.example.socialnetwork.repo.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class PostsControllers {

    private final PostsRepository postsRepository;

    private final UsersRepository usersRepository;

    private final FollowedRepository followedRepository;

    public PostsControllers(PostsRepository postsRepository, UsersRepository usersRepository, FollowedRepository followedRepository) {
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
        this.followedRepository = followedRepository;
    }

    @PostMapping("/post/add")
    public void add(@RequestBody PostsRequest postsRequest) {
        Posts posts = new Posts();
        posts.setOwner(usersRepository.getById(postsRequest.getOwner()));
        posts.setText(postsRequest.getText());
        postsRepository.save(posts);
    }

    @GetMapping("/post/get")
    public List<Posts> get() {
        return postsRepository.findAll();
    }

    @PostMapping("/set/follow")
    public void setFollow(@RequestBody Long id) {
        Followed followed = new Followed();
        followed.setOwner(usersRepository.getById(1L));
        followed.setFollowed_id(id);
        followedRepository.save(followed);
    }

    @GetMapping("/post/get/{id}")
    public List<Posts> get(@PathVariable Long id) {
        Stream<Long> userFollowed = usersRepository.getById(id).getFollowed().stream().map(Followed::getFollowed_id);

        return postsRepository.findAll();
    }
}
