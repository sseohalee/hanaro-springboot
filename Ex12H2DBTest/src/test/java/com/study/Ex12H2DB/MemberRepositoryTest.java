package com.study.Ex12H2DB;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class MemberRepositoryTest extends Ex12H2DbApplicationTests{
    // Test에서는 생성자 주입이 안됨.
    // 필드주입
    @Autowired
    MemberRepository memberRepository;

    @BeforeAll // static 메소드
    static void setup(){
        System.out.println("@BeforeAll - 클래스를 초기화시 한 번 수행");
    }

    @BeforeEach // non-static 메소드
    void init(){
        System.out.println("@BeforeEach - @Test 메소드를 호출시마다 한 번 수행");
    }

    @Test // 테스트할 메소드에 사용
    @DisplayName("save 테스트") // 콘솔에 출력되는 메소드 이름
    public void save(){
        memberRepository.save(new MemberEntity(Long.valueOf(1),"hong","1234","홍길동","ROLE_USER", LocalDate.now()));
        memberRepository.save(new MemberEntity(Long.valueOf(2),"tom","1234","톰아저씨","ROLE_USER", LocalDate.now()));
        memberRepository.save(new MemberEntity(Long.valueOf(3),"admin","1234","관리자","ROLE_ADMIN", LocalDate.now()));

        List<MemberEntity> list = memberRepository.findAll();
        for(MemberEntity m : list){
            System.out.println(m.getUserName());
        }
    }
}
