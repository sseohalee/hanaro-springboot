package com.study.Pr10MemberAdminAPI.web;

import com.study.Pr10MemberAdminAPI.domain.Member;
import com.study.Pr10MemberAdminAPI.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class HtmlController {
    private final MemberService memberService;

    @GetMapping("/")
    public String main(){
        return "join";
    }

    @GetMapping("/init")
    public String init(){
        memberService.init();
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String flag, Model model){
        model.addAttribute("flag", flag);
        return "login";
    }
    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("memberList", memberService.findAll());
        return "admin";
    }
//
    @GetMapping("/update-form/{index}")
    public String update(@PathVariable int index, Model model){
        model.addAttribute("index", index);
        model.addAttribute("member", memberService.get(index));
        return "update-form";
    }
}
