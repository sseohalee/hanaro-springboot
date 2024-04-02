package com.study.Pr08LoginJoinAPI.web;

import com.study.Pr08LoginJoinAPI.service.MemberService;
import com.study.Pr08LoginJoinAPI.web.dto.DuplReqDto;
import com.study.Pr08LoginJoinAPI.web.dto.JoinReqDto;
import com.study.Pr08LoginJoinAPI.web.dto.LoginReqDto;
import com.study.Pr08LoginJoinAPI.web.dto.MemberResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ApiController {
    private final MemberService memberService;

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
        return memberService.dupl(reqDto);
    }
}
