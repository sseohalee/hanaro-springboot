package com.study.Pr08LoginJoinAPI.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    @GetMapping("/")
    public String main(){
        return "join";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/join")
    public String signup(){
        return "join";
    }
}
