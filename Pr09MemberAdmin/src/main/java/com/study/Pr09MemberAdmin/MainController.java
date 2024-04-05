package com.study.Pr09MemberAdmin;

import org.springframework.cglib.core.Local;
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

    @GetMapping("/init")
    public String init(){
        try{
            Member member = Member.builder()
                    .username("admin")
                    .email("admin@gmail.com")
                    .password("1234")
                    .joindate(LocalDate.now())
                    .build();
            memberList.add(member);
        } catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/";
    }

    // 관리자 페이지 이동 -----------------------------
    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("memberList", memberList);
        return "admin";
    }

    // 회원 정보 수정 --------------------------------
    @GetMapping("/update-form/{index}")
    public String updateFrom(@PathVariable int index, Model model){
        model.addAttribute("index", index);
        model.addAttribute("member", memberList.get(index));
        return "update-form";
    }

    @PostMapping("/update-action")
    public String updateAction(@RequestParam int index,
                               @RequestParam String inputName,
                               @RequestParam String inputEmail,
                               @RequestParam String inputPw,
                               @RequestParam LocalDate inputJoindate){
        Member member = Member.builder()
                .username(inputName)
                .password(inputPw)
                .email(inputEmail)
                .joindate(inputJoindate)
                .build();
        memberList.set(index, member);

        return "redirect:/admin";
    }

    // 회원 삭제 -------------------------
    @GetMapping("/delete/{index}")
    public String delete(@PathVariable int index){
        memberList.remove(index);
        return "redirect:/admin";
    }


    // 회원가입 --------------------------
    @GetMapping(value={"/join/{flag}/{inputName}", "/join"})
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
    @GetMapping(value={"/login/{flag}","/login"})
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
                if(member.getUsername().equals("admin")){
                    return "redirect:/admin";
                }
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

