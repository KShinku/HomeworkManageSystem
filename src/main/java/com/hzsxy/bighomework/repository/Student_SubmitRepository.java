package com.hzsxy.bighomework.repository;

import com.hzsxy.bighomework.entity.Student_Submit;
import com.hzsxy.bighomework.entity.Student_Submit_PK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by 东旭 on 2017/5/2.
 */
@Repository
public interface Student_SubmitRepository extends CrudRepository<Student_Submit,Student_Submit_PK> {
}
