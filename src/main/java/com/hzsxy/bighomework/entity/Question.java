package com.hzsxy.bighomework.entity;

import javax.persistence.*;

/**
 * Created by 东旭 on 2017/4/30.
 */
@Entity
public class Question {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer question_id;
    @Column(length = 50,nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(length = 10)
    private String author;
    public Question() {
    }

    public Question(String title, String description, String author) {
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_id=" + question_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
