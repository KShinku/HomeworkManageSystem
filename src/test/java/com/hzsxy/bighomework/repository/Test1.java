package com.hzsxy.bighomework.repository;


import com.hzsxy.bighomework.entity.Class_Info;
import com.hzsxy.bighomework.entity.User;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by 东旭 on 2017/5/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private Class_InfoRepository class_infoRepository;
    @Test
    public void testSave(){
        User user=new User("1592010216","123456","student",null,null);
        userRepository.save(user);
    }

    @Test
    public void testDelete(){
        userRepository.delete("1592010216");
    }

    @Test
    public void testFindByAccountAndPassword(){
        User user=userRepository.findByAccountAndPassword("1592010216","123");
        System.out.println(user);
    }
    @Test
    public void saveImpl(){
        userRepository.save(new User("1592010229","123456","student",studentRepository.findOne("1592010229"),null));
        userRepository.save(new User("1592010104","123456","student",studentRepository.findOne("1592010104"),null));
    }
    @Test
    public void testQuery(){
        List<Class_Info> class_infoList= (List<Class_Info>) class_infoRepository.findAllByTeacher_id("1000000");
        System.out.println(class_infoList);
    }

}
