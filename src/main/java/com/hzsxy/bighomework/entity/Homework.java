package com.hzsxy.bighomework.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 东旭 on 2017/4/30.
 */
@Entity
public class Homework {

    @EmbeddedId
    private Homework_PK homework_pk;

    public Homework() {
    }

    public Homework(Homework_PK homework_pk) {
        this.homework_pk = homework_pk;
    }

    public Homework_PK getHomework_pk() {
        return homework_pk;
    }

    public void setHomework_pk(Homework_PK homework_pk) {
        this.homework_pk = homework_pk;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "homework_pk=" + homework_pk +
                '}';
    }

}
