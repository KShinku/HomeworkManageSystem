package com.hzsxy.bighomework.entity;



import javax.persistence.*;

/**
 * Created by 东旭 on 2017/4/30.
 */
@Entity
public class List_Question {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer list_question_id;
    @Column(length = 50,nullable = false)
    private String list_name;
    @Column
    private String description;

    public List_Question() {
    }

    public List_Question(String list_name, String description) {
        this.list_name = list_name;
        this.description = description;
    }

    public Integer getList_question_id() {
        return list_question_id;
    }

    public void setList_question_id(Integer list_question_id) {
        this.list_question_id = list_question_id;
    }

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "List_Question{" +
                "list_question_id=" + list_question_id +
                ", list_name='" + list_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
