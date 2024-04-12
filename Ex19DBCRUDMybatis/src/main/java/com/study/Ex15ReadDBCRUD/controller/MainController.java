package com.study.Ex15ReadDBCRUD.controller;

import com.study.Ex15ReadDBCRUD.dao.IMemberDao;
import com.study.Ex15ReadDBCRUD.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {
    final IMemberDao memberDao; //xml이 구현체

    @GetMapping("/")
    public String main(){
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<MemberDto> list =
                memberDao.list();
        model.addAttribute("member_list", list);
//        System.out.println("size:" + list.size());
        int count =  memberDao.count();
        model.addAttribute("listcount", count);

        return "index"; //index.html로 응답
    }
    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm"; //joinForm.html로 응답
    }
    @PostMapping("/joinAction")
    @ResponseBody
    public String joinAction(@ModelAttribute MemberDto dto){
        System.out.println("name:"+dto.getUserName());
        try {
            int result = memberDao.insert(dto);
            if(result!=1){
                System.out.println("회원가입 실패");
                return "<script>alert('회원가입 실패');history.back();</script>";
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("회원가입 실패");
            return "<script>alert('회원가입 실패');history.back();</script>";
        }
        System.out.println("회원가입 성공");
        return "<script>alert('회원가입 성공');location.href='/list';</script>";
    }
    //viewDTO?id=1
    @GetMapping("/viewMember")
    public String viewMember(@RequestParam int id, Model model){
        Optional<MemberDto> optional = memberDao.findById( id );
        if(optional.isPresent()){
            model.addAttribute("member", optional.get());
        } else{
            return "direct:/list";
        }
        return "modifyForm"; //modifyForm.html로 응답
    }

    @PostMapping("/modifyAction")
    @ResponseBody
    public String modifyAction(@ModelAttribute MemberDto dto){
        try{
            int result = memberDao.update(dto);
            if(result!=1){
                System.out.println("회원정보수정 실패");
                return "<script>alert('회원정보수정 실패');history.back();</script>";
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("회원정보수정 실패");
            return "<script>alert('회원정보수정 실패');history.back();</script>";
        }
        System.out.println("회원정보수정 성공");
        return "<script>alert('회원정보수정 성공');location.href='/list';</script>";
    }

    @GetMapping("/deleteMember")
    @ResponseBody
    public String deleteMember(@RequestParam int id){
        Optional<MemberDto> optional = memberDao.findById(id);
        if(!optional.isPresent()){
            System.out.println("회원정보조회 실패");
            return "<script>alert('회원정보조회 실패'); history.back();</script>";
        }
        try{
            memberDao.delete(id);
        }catch(Exception e){
            e.printStackTrace();
            return "<script>alert('회원정보삭제 실패'); history.back();</script>";
        }
        return "<script>alert('회원정보삭제 성공'); location.href='list';</script>";
    }
}
