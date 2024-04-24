package com.study.Ex27Security01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(){
        return "index";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }
}
