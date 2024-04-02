package com.study.Pr02Calc;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class mainController {
    @Autowired
    final Calculator calculator;

    @GetMapping("/")
    public String main(Model model){
//        model.addAttribute("number1", calculator.getNumber1());
//        model.addAttribute("number2", calculator.getNumber2());
        model.addAttribute("result", calculator.getResult());
        return "index";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam String number1, @RequestParam String number2){
        calculator.add(Integer.parseInt(number1), Integer.parseInt(number2));
        return "redirect:";
    }
    @GetMapping("/minus")
    public String minus(@RequestParam String number1, @RequestParam String number2){
        calculator.sub(Integer.parseInt(number1), Integer.parseInt(number2));
        return "redirect:";
    }
    @GetMapping("/multi")
    public String multi(@RequestParam String number1, @RequestParam String number2){
        calculator.mul(Integer.parseInt(number1), Integer.parseInt(number2));
        return "redirect:";
    }
    @GetMapping("/divi")
    public String divi(@RequestParam String number1, @RequestParam String number2){
        calculator.div(Integer.parseInt(number1), Integer.parseInt(number2));
        return "redirect:";
    }

}
