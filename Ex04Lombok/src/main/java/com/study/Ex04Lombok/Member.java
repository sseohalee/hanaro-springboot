package com.study.Ex04Lombok;

//롬복이 지원하는 어노테이션 목록
//@Getter : getter 자동생성
//@Setter : setter 자동생성
//@NoArgsConstructor : 매개변수 없는 기본생성자 자동생성
//@AllArgsConstructor : 모든 필드를 파라미터로 받는 생성자 자동생성
//@RequiredArgsConstructor : final이나 @NonNull인 필드만 매개변수로 받는 생성자 자동생성
//   : 생성자 주입에 사용
//@NonNull : null을 허용하지 않는 객체 Bean 자동생성
//@Nullable : null을 허용하는 객체 Bean 자동생성
//@Data : @Getter, @Setter,@RequiredArgsConstructor,
//        @ToString, @EqualsAndHashCode을 한꺼번에 설정해주는 어노테이션
//@ToString : toString 메소드 자동생성
//@EqualsAndHashCode : equals, hashCode 메서드 생성

import jakarta.annotation.Nullable;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
@Data // 여러개 한 번에
public class Member {
    private String name;
    @NonNull
    private String phone;
    @Nullable
    private String email;

    public Member() {}
}
