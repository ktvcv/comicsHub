package com.example.demo.repos;

import com.example.demo.entities.Comic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface ComicRepo extends CrudRepository<Comic, Long> {

    Page<Comic> findByPublisher(String publisher, Pageable pageable);
    Comic findByTitle(String publisher);

    Page<Comic> findAll(Pageable pageable);

    Comic getById(Long id);

    boolean deleteComicById(Long id);
}
