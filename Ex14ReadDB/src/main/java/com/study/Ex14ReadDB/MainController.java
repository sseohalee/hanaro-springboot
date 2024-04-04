package com.study.Ex14ReadDB;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    final MemberRepository memberRepository;

    @GetMapping("/")
    public String main(Model model){
        List<MemberEntity> list = memberRepository.findAll();
        model.addAttribute("list", list);
        System.out.println("size: "+list.size());
        return "index";
    }
}
