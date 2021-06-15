package com.example.socialnetwork.repo;

import com.example.socialnetwork.entity.Followed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowedRepository extends JpaRepository<Followed, Long> {
}
