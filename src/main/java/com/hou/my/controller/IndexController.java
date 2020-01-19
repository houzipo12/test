package com.hou.my.controller;

import com.hou.my.mapper.UserMapper;
import com.hou.my.modle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("token"));
            String token = cookie.getValue();
            User user = userMapper.findBYToken(token);
            if (user !=null){
                request.getSession().setAttribute("user",user);
            }
            break;
        }
        return "index";}

}
