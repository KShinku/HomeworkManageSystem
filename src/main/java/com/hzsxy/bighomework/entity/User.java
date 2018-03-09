package com.hzsxy.bighomework.entity;


import javax.persistence.*;

/**
 * Created by 东旭 on 2017/4/30.
 */
@Entity
public class User {
    @Id
    @Column(length = 20,nullable = false)
    private String account;
    @Column(length = 20,nullable = false)
    private String password;
    @Column(length = 10,nullable = false)
    private String type;
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student_id_fk;
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher_id_fk;

    public User() {
    }

    public User(String account, String password, String type, Student student_id_fk, Teacher teacher_id_fk) {
        this.account = account;
        this.password = password;
        this.type = type;
        this.student_id_fk = student_id_fk;
        this.teacher_id_fk = teacher_id_fk;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Student getStudent_id_fk() {
        return student_id_fk;
    }

    public void setStudent_id_fk(Student student_id_fk) {
        this.student_id_fk = student_id_fk;
    }

    public Teacher getTeacher_id_fk() {
        return teacher_id_fk;
    }

    public void setTeacher_id_fk(Teacher teacher_id_fk) {
        this.teacher_id_fk = teacher_id_fk;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", student_id_fk=" + student_id_fk +
                ", teacher_id_fk=" + teacher_id_fk +
                '}';
    }

}
