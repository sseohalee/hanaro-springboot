package com.study.Ex09RestAPI;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // @Controller + @ResponseBody(응답 문자열로)
@RequestMapping("/api/v1")
public class ApiController {
    public static List<Member> memberList = new ArrayList<>();

    // URL : localhost:8080/api/v1/login => @RequestMapping을 통해 가능
    @PostMapping("/login")
    public ResDto login(@RequestBody ReqDto reqDto){
        System.out.println(reqDto.getUsername());
        System.out.println(reqDto.getPassword());

        // 로그인 로직
        // reqDto.username이 DB(리스트)에 있는지 확인
        boolean found = false;
        for(Member member : memberList){
            if(member.getUsername().equals(reqDto.getUsername())
            && member.getPassword().equals(reqDto.getPassword())){
                found=true; // 로그인 처리! 세션객체에 로그인 상태를 저장.
                break;
            }
        }

        ResDto resDto = new ResDto();
        if(found == true) {
            resDto.setStatus("ok");
            resDto.setMessage("로그인 성공!");
        } else {
            resDto.setStatus("fail");
            resDto.setMessage("로그인 실패!");
        }
        return resDto; // 객체가 json 응답으로 넘어감 (클래스 객체가 json 응답(문자열)으로 전송된다.)
    }
}
