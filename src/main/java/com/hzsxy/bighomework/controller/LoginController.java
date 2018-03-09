package com.hzsxy.bighomework.controller;

import com.hzsxy.bighomework.entity.Student;
import com.hzsxy.bighomework.entity.Teacher;
import com.hzsxy.bighomework.entity.User;
import com.hzsxy.bighomework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 东旭 on 2017/5/2.
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String turnToIndex(HttpSession httpSession){
        if (httpSession.getAttribute("type")==null)return "index";
        return "main";
    }

    @Autowired
    UserRepository userRepository;

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestParam(value = "account") String account,
                        @RequestParam(value = "password") String password,
                        HttpSession httpSession) {
        User user=userRepository.findByAccountAndPassword(account,password);
        if(user!=null){
            String identity=user.getType();
            httpSession.setAttribute("type",identity);
            if(identity.equals("student")){
                httpSession.setAttribute("info",user.getStudent_id_fk());
            }
            else if(identity.equals("teacher")){
                httpSession.setAttribute("info",user.getTeacher_id_fk());
            }
            else
                httpSession.setAttribute("info","unknow");
            return "successful";
        }
        else return "账号密码错误";
    }
    @RequestMapping("/logout")
    @ResponseBody
    public void logout(HttpSession httpSession){
        httpSession.invalidate();
        return ;
    }
}
