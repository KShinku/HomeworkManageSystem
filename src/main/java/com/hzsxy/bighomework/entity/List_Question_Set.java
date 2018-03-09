package com.hzsxy.bighomework.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 东旭 on 2017/4/30.
 */
@Entity
public class List_Question_Set {

    @EmbeddedId
    private List_Question_Set_PK list_question_set_pk;

    public List_Question_Set() {
    }

    public List_Question_Set(List_Question_Set_PK list_question_set_pk) {
        this.list_question_set_pk = list_question_set_pk;
    }

    public List_Question_Set_PK getList_question_set_pk() {
        return list_question_set_pk;
    }

    public void setList_question_set_pk(List_Question_Set_PK list_question_set_pk) {
        this.list_question_set_pk = list_question_set_pk;
    }

    @Override
    public String toString() {
        return "List_Question_Set{" +
                "list_question_set_pk=" + list_question_set_pk +
                '}';
    }

}
