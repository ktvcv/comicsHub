package com.example.demo.repos;

import com.example.demo.entities.Comic;
import com.example.demo.entities.Favourite;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.List;

public interface FavRepo extends JpaRepository<Favourite, Long> {

   List<Favourite> findAllByAuthor(User user);

    HashSet<Comic> findAllComicsByAuthor(User user);

    void deleteAllByComicIdAndAuthor(Long id,User author);
}
