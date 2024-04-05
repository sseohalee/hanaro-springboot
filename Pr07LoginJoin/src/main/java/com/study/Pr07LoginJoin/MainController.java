package com.study.Pr07LoginJoin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    public static List<Member> memberList = new ArrayList<>();

    @GetMapping("/")
    public String main(){
        return "redirect:/join";
    }

    // 회원가입 --------------------------
    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @GetMapping("/join/{flag}/{inputName}")
    public String join(@PathVariable(required = false) String flag, @PathVariable(required = false) String inputName, Model model){
        model.addAttribute("flag",flag);
        System.out.println(flag);
        model.addAttribute("inputName",inputName);
        return "join";
    }

    @PostMapping("/join-action")
    @ResponseBody
    public String joinAction(@RequestParam String inputName,
                             @RequestParam String inputEmail,
                             @RequestParam String inputPw){
        System.out.println(inputName);
        try{
            Member member = Member.builder()
                    .username(inputName)
                    .email(inputEmail)
                    .password(inputPw)
                    .joindate(LocalDate.now())
                    .build();
            memberList.add(member);
        }catch (Exception e){
            return "<script>alert('회원가입 실패하였습니다.'); location.href='/join'</script>";
        }
        return "<script>alert('회원가입 완료하였습니다.'); location.href='/login/joinOk'</script>";
    }

    // 로그인 --------------------------------
    @GetMapping("/login/{flag}")
    public String login(@PathVariable(required = false) String flag, Model model){
        model.addAttribute("flag",flag);
        System.out.println(flag);
        return "login";
    }

    @PostMapping("/login-action")
    public String loginAction(@RequestParam String inputName,
                              @RequestParam String inputPw){
        for(Member member : memberList){
            if(member.getUsername().equals(inputName)
                && member.getPassword().equals(inputPw)){
                return "redirect:/login/loginOk";
            }
        }
        return "redirect:/login/loginFail";
    }

    // 중복확인 -------------------------------
    @GetMapping("/dupl/{inputName}")
    public String dupl(@PathVariable String inputName){
        String url="";
        for(Member member : memberList){
            if(member.getUsername().equals(inputName)){
                url = "redirect:/join/y/"+inputName;
                return url;
            }
        }
        url="redirect:/join/n/"+inputName;
        return url;
    }

}
