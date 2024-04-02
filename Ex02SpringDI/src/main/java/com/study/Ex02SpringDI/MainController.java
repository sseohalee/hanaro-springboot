package com.study.Ex02SpringDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller : HTTP 요청을 처리하는 컨트롤 클래스에 붙임.
// GET/POST/PUT/DELETE 요청 등을 처리한다.
@Controller
public class MainController {
    // GetMapping : HTTP Get 요청을 처리하는 함수에 붙인다.
    //      내부적으로 메소드는 Servlet으로 동작한다.
    // ResponseBody : 응답을 raw한 문자열(JSON)로 응답한다는 의미.
    // 요청 url : localhost:8080/

    @GetMapping("/")
    @ResponseBody
    public String main(){
        return "스프링부트 웹 애플리케이션 첫 응답!";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "테스트입니다";
    }

    // 스프링 빈을 주입받는 방법
    // 1. 필드 주입
    // @Autowired : 스프링 빈을 주입해주는 어노테이션.
    @Autowired
    private Member member1; // 주입됨 @Component로 선언된 클래스를 찾아서 주입해줌 -> 싱글톤.
    @Autowired
    private Member member2; // @Autowired는 하나에 하나씩 . 그런데 어차피 싱글톤이라 같은 것을 가리키고 있다.

    @GetMapping("/field")
    @ResponseBody
    public String field(){
        System.out.println();
        return "field() 호출됨."+member1.getName(); // bean이 가지고 있던 이순신이 출력된다.
    }

    // 2. 수정자(setter) 주입
    private Member member3;
    @Autowired
    public void setMember(Member member){
        this.member3 = member;
    }
    @GetMapping("/setter")
    @ResponseBody
    public String setter(){
        return "setter() 호출됨: " +member3.getName();
    }

    // 3. 생성자(constructor) 주입 -추천
    // 1. final 키워드 사용가능
    // 2. 생성자로서 미리 주입을 받을 수 있다. null safety를 제공.
    private  final Member member4;

    @Autowired // MainController의 생성자로 선언
    public MainController(Member member){
        this.member4 = member;
    }
    @GetMapping("constructor")
    @ResponseBody
    public String constructor(){
        return "constructor()호출됨: " + member4.getName();
    }

    // 스프링쓰면 객체 관리 안해도됨
    // 개발자가 new를 사용하지 않아도됨 -> 않도록함 (레거시 자바 프로그램)

}
