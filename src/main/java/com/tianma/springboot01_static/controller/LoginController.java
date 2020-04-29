package com.tianma.springboot01_static.controller;

import com.sun.net.httpserver.HttpsServer;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author lgc
 * @createDate 2020/4/28 - 16:42
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public  String login(@RequestParam("username") String username, @RequestParam("password") String password
            , Map<String,Object> map, HttpSession session){
        System.out.println();
        if (!StringUtils.isEmpty(username)&&"123".equals(password)) {
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        map.put("msg","用户名或密码错误");
        return "login";
    }
}
