package com.hzsxy.bighomework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzsxy.bighomework.entity.*;
import com.hzsxy.bighomework.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 东旭 on 2017/5/17.
 */
@Controller
public class TeacherController implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession httpSession = httpServletRequest.getSession();
        if (httpSession.getAttribute("type") == "teacher") return true;
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    @Autowired
    Class_InfoRepository class_infoRepository;
    @Autowired
    HomeworkRepository homeworkRepository;
    @Autowired
    List_Question_SetRepository list_question_setRepository;
    @Autowired
    List_QuestionRepository list_questionRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/classes")
    public String returnClasspage(Model model, HttpSession httpSession, @RequestParam("class_id")String class_id){
        Class_Info class_info=class_infoRepository.findOne(class_id);
        model.addAttribute("class_info",class_info);
        List<Student> studentList= (List<Student>) studentRepository.findAllByClass_id(class_id);
        model.addAttribute("student_info",studentList);
        return "teacher/class-management";
    }

    @RequestMapping("/questions")
    public String returnQuestionpage(Model model){
        List<Question> questions= (List<Question>) questionRepository.findAll();
        model.addAttribute("question_info",questions);
        return "teacher/question-management";
    }

    @RequestMapping("/addquestion")
    public String returnAddQuestionpage(){
        return "teacher/question-add";
    }

    @RequestMapping(value = "/question/add",method = RequestMethod.POST)
    @ResponseBody
    public String addQuestion(HttpServletRequest httpServletRequest,HttpSession httpSession){
        String title=httpServletRequest.getParameter("title");
        String description=httpServletRequest.getParameter("description");
        String author = ((Teacher)httpSession.getAttribute("info")).getName();
        Question question=new Question(title,description,author);
        try {
            questionRepository.save(question);
            return "successful";
        }catch (Exception e){
            return "failed";
        }
    }

    @RequestMapping(value = "/question/delete",method = RequestMethod.POST)
    @ResponseBody
    public String deleteQuestion(HttpServletRequest httpServletRequest){
        int question_id = Integer.parseInt(httpServletRequest.getParameter("question_id"));

        try {
            questionRepository.delete(question_id);
            return "successful";
        }catch (Exception e){
            return "failed";
        }
    }

    @RequestMapping("/editquestion")
    public String returnEditQuestionpage(Model model,HttpSession httpSession,@RequestParam("question_id")String question_id){
        Question question =questionRepository.findOne(Integer.valueOf(question_id));
        model.addAttribute("question_info",question);
        return "teacher/question-edit";
    }

    @RequestMapping("/question/edit")
    @ResponseBody
    public String editQuestion(HttpServletRequest httpServletRequest,HttpSession httpSession){
        int question_id= Integer.parseInt(httpServletRequest.getParameter("question_id"));
        String title=httpServletRequest.getParameter("title");
        String description=httpServletRequest.getParameter("description");
        String author = ((Teacher)httpSession.getAttribute("info")).getName();
        try{
            Question question=questionRepository.findOne(question_id);
            question.setTitle(title);
            question.setDescription(description);
            question.setAuthor(author);
            questionRepository.save(question);
            return "successful";
        }catch (Exception e){
            return "failed";
        }
    }

    @RequestMapping("/lists")
    public String returnListpage(Model model){
        List<List_Question> list_questions = (List<List_Question>) list_questionRepository.findAll();
        model.addAttribute("lists",list_questions);
        return "teacher/list-management";
    }

    @RequestMapping("/addlist")
    public String returnAddListpage(Model model,HttpSession httpSession){
        Teacher teacher= (Teacher) httpSession.getAttribute("info");
        List<Class_Info> class_infos= (List<Class_Info>) class_infoRepository.findAllByTeacher_id(teacher.getTeacher_id());
        model.addAttribute("class_info",class_infos);
        List<Question> questions= (List<Question>) questionRepository.findAll();
        model.addAttribute("question_info",questions);
        return "teacher/list-add";
    }

    @RequestMapping(value = "/list/add",method = RequestMethod.POST)
    @ResponseBody
    public String addList(HttpServletRequest httpServletRequest){
        try {
            String class_id=httpServletRequest.getParameter("class_id");
            //获取题目对象
            String temp[] =httpServletRequest.getParameter("question_id_list").split(",");
            List<Integer> question_id_list=new ArrayList<Integer>();
            for(int i = 0; i < temp.length; i++)question_id_list.add(Integer.parseInt(temp[i].trim()));
            List<Question> questions= (List<Question>) questionRepository.findAll(question_id_list);
            //新建题目集对象
            List_Question list_question =new List_Question(httpServletRequest.getParameter("list_name"),httpServletRequest.getParameter("description"));
            list_questionRepository.save(list_question);
            //将题目存入题目集
            List<List_Question_Set> list_question_sets =new ArrayList<List_Question_Set>();
            for(Question question :questions){
                List_Question_Set list_question_set =new List_Question_Set(new List_Question_Set_PK(list_question,question));
                list_question_sets.add(list_question_set);
            }
            list_question_setRepository.save(list_question_sets);
            //如果班级对象不为空，将作业集发布给班级
            if(!class_id.equals("null")){
                Class_Info class_info = class_infoRepository.findOne(class_id);
                Homework homework=new Homework(new Homework_PK(list_question,class_info));
                homeworkRepository.save(homework);
            }
            return "successful";
        }catch (Exception e){
            return "failed";
        }
    }

    @RequestMapping(value = "/list/delete",method = RequestMethod.POST)
    @ResponseBody
    public String deleteList(HttpServletRequest httpServletRequest){
        try {
            int list_question_id= Integer.parseInt(httpServletRequest.getParameter("list_question_id"));
            //删除关联的作业
            List<Homework> homeworks= (List<Homework>) homeworkRepository.findAllByList_question_id(list_question_id);
            homeworkRepository.delete(homeworks);
            //删除关联的题目集
            List<List_Question_Set> list_question_sets= (List<List_Question_Set>) list_question_setRepository.findAllByList_question_id(list_question_id);
            list_question_setRepository.delete(list_question_sets);
            //删除题目集
            List_Question list_question=list_questionRepository.findOne(list_question_id);
            list_questionRepository.delete(list_question);
            return "successful";
        }catch (Exception e){
            return "failed";
        }
    }
}