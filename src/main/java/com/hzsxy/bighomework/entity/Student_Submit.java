package com.hzsxy.bighomework.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 东旭 on 2017/4/30.
 */
@Entity
public class Student_Submit {

    @EmbeddedId
    private Student_Submit_PK student_submit_pk;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String answer;
    @Column(nullable = false)
    private Timestamp submit_time;

    public Student_Submit() {
    }

    public Student_Submit(Student_Submit_PK student_submit_pk, String answer, Timestamp submit_time) {
        this.student_submit_pk = student_submit_pk;
        this.answer = answer;
        this.submit_time = submit_time;
    }

    public Student_Submit_PK getStudent_submit_pk() {
        return student_submit_pk;
    }

    public void setStudent_submit_pk(Student_Submit_PK student_submit_pk) {
        this.student_submit_pk = student_submit_pk;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Timestamp getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(Timestamp submit_time) {
        this.submit_time = submit_time;
    }

    @Override
    public String toString() {
        return "Student_Submit{" +
                "student_submit_pk=" + student_submit_pk +
                ", answer='" + answer + '\'' +
                ", submit_time=" + submit_time +
                '}';
    }

}
