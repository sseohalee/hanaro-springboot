package com.study.Ex12H2DB;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

//@Entity DB 테이블과 1:1로 매칭되는 JPA 클래스에 사용한다.
//@Table(name="member") 클래스이름이 테이블 이름으로 기본 설정되는데 ("memberEntity") 테이블 이름을 바꿔주는데 사용
@Entity
@Table(name="member")
@Getter // @Setter는 안넣는 것을 추천한다.
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    // 1. IDENTITY : MySQL, MariaDB, PostreDQL, H2DB
    // 2. SEQUENCE : Oracle, PostreSQL
    // 3. AUTO : 자동으로 선택함
    @Id // 기본키 id열로 사용한다는 의미
    @GeneratedValue(strategy= GenerationType.IDENTITY) // 해당 ID값을 어떻게 생성할지 전략을 선택한다.
    private Long id; // bigint
    // @Column : DB열과 매칭 - 변수이름과 DB열의 이름이 다를 때 매칭해준다.
    @Column(name="user_id")
    private String userId; // varchar
    @Column(name="user_pw")
    private String userPw; //
    @Column(name="user_name")
    private String userName;
    @Column(name="user_role")
    private String userRole;
    // @JsonFormat : @RequestBody @ResponseBody 매핑
    // @DateTimeFormat : @RequestParam @ModelAttribute 매핑
    // @DateTimeFormat : DB Date 테이터를 가져올때, 형식화해준다.
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate joindate;
}
