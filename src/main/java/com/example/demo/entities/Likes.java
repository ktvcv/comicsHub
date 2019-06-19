package com.example.demo.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "likes")
public class Likes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String plotMark;
    private String pictureMark;
    private String impressionMark;

    public Likes(String plotMark, String pictureMark, String impressionMark) {
        this.pictureMark = plotMark;
        this.plotMark = pictureMark;
        this.impressionMark = impressionMark;
    }

    public Likes() {
    }

    public String getPlotMark() {
        return plotMark;
    }

    public void setPlotMark(String plotMark) {
        this.plotMark = plotMark;
    }

    public String getPictureMark() {
        return pictureMark;
    }

    public void setPictureMark(String pictureMark) {
        this.pictureMark = pictureMark;
    }

    public String getImpressionMark() {
        return impressionMark;
    }

    public void setImpressionMark(String impressionMark) {
        this.impressionMark = impressionMark;
    }
}
