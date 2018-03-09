package com.hzsxy.bighomework.repository;

import com.hzsxy.bighomework.entity.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 东旭 on 2017/5/2.
 */
@Repository
public interface QuestionRepository extends CrudRepository<Question,Integer> {

}
