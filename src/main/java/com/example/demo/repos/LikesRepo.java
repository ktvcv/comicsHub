package com.example.demo.repos;

import com.example.demo.entities.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepo extends JpaRepository<Likes,Long> {
}
