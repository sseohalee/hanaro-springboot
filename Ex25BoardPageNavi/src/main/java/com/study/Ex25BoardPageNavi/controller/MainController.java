package com.study.Ex25BoardPageNavi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(){
        return "redirect:/board/";
    }
    @GetMapping("/apiForm")
    public String apiForm(){
        return "apiForm"; //apiForm.html로 응답
    }
}