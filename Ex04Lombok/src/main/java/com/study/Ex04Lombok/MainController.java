package com.study.Ex04Lombok;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor // 생성자 자동 생성 -> 코드 생략 부분 생략해도 가능토록
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String main(){
        return "롬복 예제입니다.";
    }

    // 필드 주입
    @Autowired
    private Member member1;

    // 생성자 주입
    private final Member member2;



    // 생성자 코드 생략
//    @Autowired
//    public MainController(Member member){
//        this.member2=member;
//    }
}
