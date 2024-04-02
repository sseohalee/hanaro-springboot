package com.study.Pr01Counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("count", counter.getCount());
        return "index";
    }

    @Autowired
    private Counter counter;

    @GetMapping("/plus")
    public String plus(Model model){
        int count = counter.getCount();
        counter.setCount(++count);
        return "redirect:";
    }

    @GetMapping("/minus")
    public String minus(Model model){
        int count = counter.getCount();
        counter.setCount(--count);
        return "redirect:";
    }
}
