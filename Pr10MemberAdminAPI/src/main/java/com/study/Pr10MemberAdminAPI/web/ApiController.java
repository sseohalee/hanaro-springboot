package com.study.Pr10MemberAdminAPI.web;

import com.study.Pr10MemberAdminAPI.domain.Member;
import com.study.Pr10MemberAdminAPI.service.MemberService;
import com.study.Pr10MemberAdminAPI.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ApiController {
    private final MemberService memberService;

    @GetMapping("/members")
    public List<Member> members(){
        return memberService.findAll();
    }

//    @GetMapping("/member/{index}")
//    public Member member(@PathVariable int index){
//        return memberService.get(index);
//    }

    @PutMapping("/member")
    public MemberResDto edit(@RequestBody EditReqDto reqDto){
        return memberService.edit(reqDto);
    }

    @PostMapping("/login")
    public MemberResDto login(@RequestBody LoginReqDto reqDto){
        return memberService.login(reqDto);
    }

    @PostMapping("/join")
    public MemberResDto join(@RequestBody JoinReqDto reqDto){
        return memberService.save(reqDto);
    }

    @PostMapping("/dupl")
    public MemberResDto dupl(@RequestBody DuplReqDto reqDto){
//        memberService.findByName(reqDto.getInputName()).orElseThrow(() -> new IllegalArgumentException("중복된 이름이 있습니다."));

        return memberService.dupl(reqDto);
    }

    //~/delete/1
    @DeleteMapping("/delete/{index}")
    public MemberResDto delete(@PathVariable int index){
        return memberService.delete(index);
    }

//    @PutMapping("/members")
//    public MemberResDto edit(@RequestBody)
}
