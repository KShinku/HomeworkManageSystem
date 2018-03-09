package com.hzsxy.bighomework.repository;

import com.hzsxy.bighomework.entity.Homework;
import com.hzsxy.bighomework.entity.Homework_PK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 东旭 on 2017/5/2.
 */
@Repository
public interface HomeworkRepository extends CrudRepository<Homework,Homework_PK> {

    @Query("select homework from Homework homework where homework.homework_pk.class_id_fk.class_id=?1")
    Iterable<Homework> findAllByClass_id(String class_id);
    @Query("select homework from Homework homework where homework.homework_pk.list_question_id_fk.list_question_id=?1")
    Iterable<Homework> findAllByList_question_id(Integer list_question_id);

}
