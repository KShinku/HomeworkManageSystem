package com.hzsxy.bighomework.repository;

import com.hzsxy.bighomework.entity.Student;
import com.hzsxy.bighomework.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 东旭 on 2017/5/1.
 */
@Repository
public interface UserRepository extends CrudRepository<User,String>{

    User findByAccountAndPassword(String account,String password);


}
