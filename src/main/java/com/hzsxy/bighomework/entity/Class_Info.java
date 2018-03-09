package com.hzsxy.bighomework.entity;


import javax.persistence.*;

/**
 * Created by 东旭 on 2017/4/30.
 */
@Entity
public class Class_Info {
    @Id
    @Column(length = 20,nullable = false)
    private String class_id;
    @Column(length = 20,nullable = false)
    private String class_name;
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id",nullable = false)
    private Teacher teacher_id_fk;

    public Class_Info() {
    }

    public Class_Info(String class_id, String class_name, Teacher teacher_id_fk) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.teacher_id_fk = teacher_id_fk;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Teacher getTeacher_id_fk() {
        return teacher_id_fk;
    }

    public void setTeacher_id_fk(Teacher teacher_id_fk) {
        this.teacher_id_fk = teacher_id_fk;
    }

    @Override
    public String toString() {
        return "Class_Info{" +
                "class_id='" + class_id + '\'' +
                ", class_name='" + class_name + '\'' +
                ", teacher_id_fk=" + teacher_id_fk +
                '}';
    }
}
