package com.codegym.model;

import org.hibernate.internal.util.Cloneable;

import javax.persistence.*;

@Entity
public class Img extends Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(50)")
    private String author;

    @Column(columnDefinition = "varchar(500)")
    private String feedback;

    @Column(columnDefinition = "varchar(50)")
    private String mark;

    public Img() {
    }

    public Img(Long id, String author, String feedback, String mark) {
        this.id = id;
        this.author = author;
        this.feedback = feedback;
        this.mark = mark;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
    @Override
    public Img clone() {
        Img img = new Img();
        img.setId(id);
        img.setAuthor(author);
        img.setFeedback(feedback);
        img.setMark(mark);
        return img;
    }

    @Override
    public String toString() {
        return "Img{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", feedback='" + feedback + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
