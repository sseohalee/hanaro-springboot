package com.study.Ex03Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String main(){
        return "스프링부트 웹 어플입니다.";
    }

    // 필드 주입
    @Autowired
    private Member member; // 이렇게만해도 필드 주입

    @GetMapping("/member")
    @ResponseBody
    public String member(){
        member.setName("홍길동");
        return "member() 호출됨: "+ member.getName();
    }

    @Autowired
    @Qualifier("cardBC") // !!주입되어야 할 친구를 직접 지정 ( 여기서는 cardBc or kakaoCard )
    ICard iCard; // 인터페이스 구현 객체를 주입해줌.
                // BCCard, KakaoCard -> 둘 중에 하나

    @GetMapping("/card")
    @ResponseBody
    public String card(){
        member.setiCard(iCard);
        member.getiCard().buy("mobilePhone"); // 이렇게만 하면 오류 발생 -> BC인지 kakao인지 몰라서
        return "card() 호출됨";
    }

}
