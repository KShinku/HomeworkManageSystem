package com.hzsxy.bighomework.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 东旭 on 2017/5/2.
 */
@Embeddable
public class Homework_PK implements Serializable {

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name ="list_question_id",nullable = false)
    private List_Question list_question_id_fk;

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name ="class_id",nullable = false)
    private Class_Info class_id_fk;

    public Homework_PK() {
    }

    public Homework_PK(List_Question list_question_id_fk, Class_Info class_id_fk) {
        this.list_question_id_fk = list_question_id_fk;
        this.class_id_fk = class_id_fk;
    }

    public List_Question getList_question_id_fk() {
        return list_question_id_fk;
    }

    public void setList_question_id_fk(List_Question list_question_id_fk) {
        this.list_question_id_fk = list_question_id_fk;
    }

    public Class_Info getClass_id_fk() {
        return class_id_fk;
    }

    public void setClass_id_fk(Class_Info class_id_fk) {
        this.class_id_fk = class_id_fk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Homework_PK that = (Homework_PK) o;

        if (!list_question_id_fk.equals(that.list_question_id_fk)) return false;
        return class_id_fk.equals(that.class_id_fk);
    }

    @Override
    public int hashCode() {
        int result = list_question_id_fk.hashCode();
        result = 31 * result + class_id_fk.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Homework_PK{" +
                "list_question_id_fk=" + list_question_id_fk +
                ", class_id_fk=" + class_id_fk +
                '}';
    }
}
