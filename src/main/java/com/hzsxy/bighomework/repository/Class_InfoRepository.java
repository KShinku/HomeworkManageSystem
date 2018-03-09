package com.hzsxy.bighomework.repository;


import com.hzsxy.bighomework.entity.Class_Info;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 东旭 on 2017/5/2.
 */
@Repository
public interface Class_InfoRepository extends CrudRepository<Class_Info,String> {
    @Query("select class_info from Class_Info class_info where class_info.teacher_id_fk.teacher_id=?1")
    Iterable<Class_Info> findAllByTeacher_id(String teacher);
}
