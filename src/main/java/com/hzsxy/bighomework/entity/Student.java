package com.hzsxy.bighomework.entity;

import javax.persistence.*;

/**
 * Created by 东旭 on 2017/4/30.
 */
@Entity
public class Student {

    @Id
    @Column(length = 20,nullable = false)
    private String student_id;
    @Column(length = 10,nullable = false)
    private String name;
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name ="class_id")
    private Class_Info class_id_fk;

    public Student() {
    }

    public Student(String student_id, String name, Class_Info class_id_fk) {
        this.student_id = student_id;
        this.name = name;
        this.class_id_fk = class_id_fk;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class_Info getClass_id_fk() {
        return class_id_fk;
    }

    public void setClass_id_fk(Class_Info class_id_fk) {
        this.class_id_fk = class_id_fk;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id='" + student_id + '\'' +
                ", name='" + name + '\'' +
                ", class_id_fk=" + class_id_fk +
                '}';
    }
}
