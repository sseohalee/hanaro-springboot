package com.study.Ex22TDD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    MemberService memberService;

    @PostMapping("/api/v1/loginAction")
    public ResultDto loginAction(@RequestBody ReqDto dto){
        Member member = Member.builder()
                .loginId(dto.getLoginId())
                .loginPw(dto.getLoginPw())
                .build();

        int result = memberService.loginAction(member);
        ResultDto resultDto = new ResultDto();
        if(result ==1){
            resultDto.setStatus("ok");
            resultDto.setMessage("로그인 성공!");
        } else {
            resultDto.setStatus("fail");
            resultDto.setMessage("로그인 실패!");
        }

        return resultDto;
    }
}
