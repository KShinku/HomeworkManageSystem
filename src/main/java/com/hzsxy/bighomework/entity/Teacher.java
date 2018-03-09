package com.hzsxy.bighomework.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 东旭 on 2017/4/30.
 */
@Entity
public class Teacher {

    @Id
    @Column(length = 20,nullable = false)
    private String teacher_id;
    @Column(length = 10,nullable = false)
    private String name;

    public Teacher() {
    }

    public Teacher(String teacher_id, String name) {
        this.teacher_id = teacher_id;
        this.name = name;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id='" + teacher_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
