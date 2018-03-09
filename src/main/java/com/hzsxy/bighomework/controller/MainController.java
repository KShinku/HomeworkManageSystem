package com.hzsxy.bighomework.controller;

import com.hzsxy.bighomework.entity.Class_Info;
import com.hzsxy.bighomework.entity.Student;
import com.hzsxy.bighomework.entity.Teacher;
import com.hzsxy.bighomework.repository.Class_InfoRepository;
import com.hzsxy.bighomework.repository.StudentRepository;
import com.hzsxy.bighomework.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 东旭 on 2017/5/5.
 */
@Controller
public class MainController implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
            HttpSession httpSession=httpServletRequest.getSession();
            if (httpSession.getAttribute("type")==null)return false;
            return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    Class_InfoRepository class_infoRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @RequestMapping("/sidebar")
    public String returnSidebar(Model model,HttpSession httpSession){
        String type= (String) httpSession.getAttribute("type");
        if(type.equals("student")){
            Student student= (Student) httpSession.getAttribute("info");
            model.addAttribute("student_info",student);
            return "student/sidebar-menu";
        }
        else if(type.equals("teacher")){
            Teacher teacher= (Teacher) httpSession.getAttribute("info");
            model.addAttribute("teacher_info",teacher);
            List<Class_Info> class_infos= (List<Class_Info>) class_infoRepository.findAllByTeacher_id(teacher.getTeacher_id());
            model.addAttribute("class_info",class_infos);
            return "teacher/sidebar-menu";
        }
        else
            return "error";
    }

    @RequestMapping("/homepage")
    public String returnHomepage(Model model,HttpSession httpSession){
        String type= (String) httpSession.getAttribute("type");
        if(type.equals("student")){
            Student student= (Student) httpSession.getAttribute("info");
            model.addAttribute("student_info",student);
            model.addAttribute("class_info",student.getClass_id_fk());
            model.addAttribute("teacher_info",student.getClass_id_fk().getTeacher_id_fk());
            return "student/homepage";
        }
        else if(type.equals("teacher")){
            return "teacher/homepage";
        }
        else
            return "error";
    }

}
