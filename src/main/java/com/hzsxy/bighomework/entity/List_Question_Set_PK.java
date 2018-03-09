package com.hzsxy.bighomework.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 东旭 on 2017/5/2.
 */
@Embeddable
public class List_Question_Set_PK implements Serializable {

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name ="list_question_id",nullable = false)
    private List_Question list_question_id_fk;
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name ="question_id",nullable = false)
    private Question question_id_fk;

    public List_Question_Set_PK() {
    }

    public List_Question_Set_PK(List_Question list_question_id_fk, Question question_id_fk) {
        this.list_question_id_fk = list_question_id_fk;
        this.question_id_fk = question_id_fk;
    }

    public List_Question getList_question_id_fk() {
        return list_question_id_fk;
    }

    public void setList_question_id_fk(List_Question list_question_id_fk) {
        this.list_question_id_fk = list_question_id_fk;
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

        List_Question_Set_PK that = (List_Question_Set_PK) o;

        if (!list_question_id_fk.equals(that.list_question_id_fk)) return false;
        return question_id_fk.equals(that.question_id_fk);
    }

    @Override
    public int hashCode() {
        int result = list_question_id_fk.hashCode();
        result = 31 * result + question_id_fk.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "List_Question_Set_PK{" +
                "list_question_id_fk=" + list_question_id_fk +
                ", question_id_fk=" + question_id_fk +
                '}';
    }

}
