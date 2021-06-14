package com.example.socialnetwork.repo;

import com.example.socialnetwork.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    boolean existsByLoginAndPassword(String login, String password);
    boolean existsByLogin(String login);
}
