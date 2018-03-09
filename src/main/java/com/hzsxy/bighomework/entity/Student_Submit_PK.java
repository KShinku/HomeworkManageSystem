package com.hzsxy.bighomework.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 东旭 on 2017/5/2.
 */
@Embeddable
public class Student_Submit_PK implements Serializable {
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id",nullable = false)
    private Student student_id_fk;
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id",nullable = false)
    private Question question_id_fk;

    public Student_Submit_PK() {
    }

    public Student_Submit_PK(Student student_id_fk, Question question_id_fk) {
        this.student_id_fk = student_id_fk;
        this.question_id_fk = question_id_fk;
    }

    public Student getStudent_id_fk() {
        return student_id_fk;
    }

    public void setStudent_id_fk(Student student_id_fk) {
        this.student_id_fk = student_id_fk;
    }

    public Question getQuestion_id_fk() {
        return question_id_fk;
    }

    public void setQuestion_id_fk(Question question_id_fk) {
        this.question_id_fk = question_id_fk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student_Submit_PK that = (Student_Submit_PK) o;

        if (!student_id_fk.equals(that.student_id_fk)) return false;
        return question_id_fk.equals(that.question_id_fk);
    }

    @Override
    public int hashCode() {
        int result = student_id_fk.hashCode();
        result = 31 * result + question_id_fk.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Student_Submit_PK{" +
                "student_id_fk=" + student_id_fk +
                ", question_id_fk=" + question_id_fk +
                '}';
    }

}
