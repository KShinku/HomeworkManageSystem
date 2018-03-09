package com.hzsxy.bighomework.repository;

import com.hzsxy.bighomework.entity.List_Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 东旭 on 2017/5/2.
 */
@Repository
public interface List_QuestionRepository extends CrudRepository<List_Question,Integer> {

}
