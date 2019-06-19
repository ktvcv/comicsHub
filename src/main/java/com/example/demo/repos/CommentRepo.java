package com.example.demo.repos;

import com.example.demo.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CommentRepo extends JpaRepository<Comment, Long> {

    public Set<Comment> findCommentByAuthorId(Long id);
    public Set<Comment> findCommentByComicId(Long id);

}
