package com.study.Pr08LoginJoinAPI.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HtmlController {
    @GetMapping("/")
    public String main(){
        return "join";
    }
    @GetMapping("/login")
    public String login(@RequestParam(required = false) String flag, Model model){
        model.addAttribute("flag", flag);
        return "login";
    }
    @GetMapping("/join")
    public String signup(){
        return "join";
    }
}
