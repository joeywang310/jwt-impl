package com.wzc.jwt.controller;

import com.wzc.jwt.annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: joey
 * Date: 2019-03-29 16:49
 */
@Controller
public class IndexController {

    @Login
    @GetMapping("index")
    public String index(){
        System.out.println("index");
        return "index";
    }



    @GetMapping("login")
    public String login(){
        return "login";
    }

}
