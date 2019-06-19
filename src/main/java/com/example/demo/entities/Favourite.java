package com.example.demo.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "favourites")
public class Favourite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comic_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Comic comic;

    public Favourite( User author, Comic comic) {

        this.author = author;
        this.comic = comic;
    }

    public Favourite() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }


    @Override
    public int hashCode() {

        return Objects.hash(comic);
    }
}
