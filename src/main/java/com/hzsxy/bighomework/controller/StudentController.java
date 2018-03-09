package com.hzsxy.bighomework.controller;

import com.hzsxy.bighomework.entity.*;
import com.hzsxy.bighomework.model.Homework_View;
import com.hzsxy.bighomework.repository.HomeworkRepository;
import com.hzsxy.bighomework.repository.List_Question_SetRepository;
import com.hzsxy.bighomework.repository.QuestionRepository;
import com.hzsxy.bighomework.repository.Student_SubmitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by 东旭 on 2017/5/17.
 */
@Controller
public class StudentController implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession httpSession = httpServletRequest.getSession();
        if (httpSession.getAttribute("type") == "student") return true;
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    @Autowired
    HomeworkRepository homeworkRepository;
    @Autowired
    List_Question_SetRepository list_question_setRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    Student_SubmitRepository student_submitRepository;

    @RequestMapping("/homework")
    public String returnHomework(Model model,HttpSession httpSession){
        Student student= (Student) httpSession.getAttribute("info");
        String class_info_id=student.getClass_id_fk().getClass_id();
        List<Homework> homeworks = (List<Homework>) homeworkRepository.findAllByClass_id(class_info_id);
        List<Homework_View> homework_views=new ArrayList<Homework_View>();
        for(Homework homework:homeworks){
            Homework_View homework_view = new Homework_View();
            homework_view.setHomework_pk(homework.getHomework_pk());
            List<List_Question_Set> list_question_sets = (List<List_Question_Set>) list_question_setRepository.findAllByList_question_id(homework.getHomework_pk().getList_question_id_fk().getList_question_id());
            homework_view.setList_question_sets(list_question_sets);
            homework_views.add(homework_view);
        }
        model.addAttribute("homework_info",homework_views);
        return "student/homework";
    }

    @RequestMapping("/answerpage")
    public String returnAnswerpage(@RequestParam("question_id") int question_id,Model model, HttpSession httpSession){
        Question question=questionRepository.findOne(question_id);
        model.addAttribute("question",question);
        return "student/submit-answer";
    }

    @RequestMapping(value = "/submit-answer",method = {RequestMethod.PUT})
    @ResponseBody
    public String submitAnswer(HttpServletRequest httpServletRequest,HttpSession httpSession){
        int question_id= Integer.parseInt(httpServletRequest.getParameter("question_id"));
        String answer =httpServletRequest.getParameter("answer");
        Student student= (Student) httpSession.getAttribute("info");
        try{
            Question question=questionRepository.findOne(question_id);
            if(question!=null) {
                Student_Submit student_submit = new Student_Submit(new Student_Submit_PK(student, question), answer, new Timestamp(new Date().getTime()));
                student_submitRepository.save(student_submit);
                return "seccussful";
            }
            return "failed";
        }catch (Exception e){
            return "failed";
        }
    }

}