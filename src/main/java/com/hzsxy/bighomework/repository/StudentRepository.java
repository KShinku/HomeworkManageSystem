package com.hzsxy.bighomework.repository;

import com.hzsxy.bighomework.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 东旭 on 2017/5/2.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student,String>{
    @Query("select student from Student student where student.class_id_fk.class_id=?1")
    Iterable<Student> findAllByClass_id(String class_id);
}
