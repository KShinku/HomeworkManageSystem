package com.hzsxy.bighomework.model;

import com.hzsxy.bighomework.entity.Homework_PK;
import com.hzsxy.bighomework.entity.List_Question_Set;
import com.hzsxy.bighomework.entity.Question;

import java.util.List;

/**
 * Created by 东旭 on 2017/5/17.
 */
public class Homework_View {
    private Homework_PK homework_pk;
    private List<List_Question_Set> list_question_sets;

    public Homework_View() {
    }

    public Homework_View(Homework_PK homework_pk, List<List_Question_Set> list_question_sets) {
        this.homework_pk = homework_pk;
        this.list_question_sets = list_question_sets;
    }

    public Homework_PK getHomework_pk() {
        return homework_pk;
    }

    public void setHomework_pk(Homework_PK homework_pk) {
        this.homework_pk = homework_pk;
    }

    public List<List_Question_Set> getList_question_sets() {
        return list_question_sets;
    }

    public void setList_question_sets(List<List_Question_Set> list_question_sets) {
        this.list_question_sets = list_question_sets;
    }

    @Override
    public String toString() {
        return "Homework_View{" +
                "homework_pk=" + homework_pk +
                ", list_question_sets=" + list_question_sets +
                '}';
    }
}
