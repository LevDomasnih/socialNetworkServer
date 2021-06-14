package com.example.socialnetwork.repo;

import com.example.socialnetwork.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
