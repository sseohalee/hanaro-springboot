package com.study.Ex02SpringDI;

// 스프링에서 빈 생성시 POJO 클래스를 이용한다.
// POJO : EJB와 달리 순수한 자바 클래스로 만들어준다. getter/setter/생성자만 추가해서 빈을 만든다.

import org.springframework.stereotype.Component;

@Component
public class Member {
    private String name = "이순신";
    // 기본생성자 -> 필수 뺴먹어서 오류 발생 가능성 다분 
    public Member(){}
    // 매개변수있는 생성자
    public Member(String name) {
        this.name = name;
    }

    // getter/setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
