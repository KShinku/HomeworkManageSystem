package com.hzsxy.bighomework.repository;

import com.hzsxy.bighomework.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 东旭 on 2017/5/2.
 */
@Repository
public interface TeacherRepository extends CrudRepository<Teacher,String> {

}
