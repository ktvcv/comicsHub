package com.example.demo.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "comments")
public class Comment extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Комментарий не должен содержать нецензурную лексику и оскорблений")
    @Length(max = 255, message = "Комментарий слишком длинный")
    private String text;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comic_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Comic comic;

    public Comment(String text, User author,Comic comic) {
        this.text = text;
        this.author = author;
        this.comic = comic;
    }


    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

}
