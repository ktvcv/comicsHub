package com.example.demo.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "comics")
public class Comic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String publisher;
    @NotNull
    private String filename1;
    private String filename2;
    private String filename3;
    private String year;
    private String screenwriter;
    private String artist;
    private String description;
    private String hyperlinkRu;
    private String hyperlinkEng;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "likes_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Likes likes;

    public Likes getLikes() {
        return likes;
    }



    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    public String getHyperlinkRu() {
        return hyperlinkRu;
    }

    public void setHyperlinkRu(String hyperlinkRu) {
        this.hyperlinkRu = hyperlinkRu;
    }

    public String getHyperlinkEng() {
        return hyperlinkEng;
    }

    public void setHyperlinkEng(String hyperlinkEng) {
        this.hyperlinkEng = hyperlinkEng;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Comic(@NotNull String title, @NotNull String publisher)
    {
        this.title = title;
        this.publisher = publisher;

    }


    public Comic() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter;
    }

    public String getFilename1() {
        return filename1;
    }

    public void setFilename1(String filename1) {
        this.filename1 = filename1;
    }

    public String getFilename2() {
        return filename2;
    }

    public void setFilename2(String filename2) {
        this.filename2 = filename2;
    }

    public String getFilename3() {
        return filename3;
    }

    public void setFilename3(String filename3) {
        this.filename3 = filename3;
    }

    public String getArtist() {
        return artist;
    }


    public void setArtist(String artist) {
        this.artist = artist;
    }
}
