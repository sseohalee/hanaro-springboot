package com.study.Pr08LoginJoinAPI.web.dto;

import com.study.Pr08LoginJoinAPI.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class JoinReqDto {
    private String inputName;
    private String inputEmail;
    private String inputPw;
    private String inputPw2;

    public JoinReqDto(String inputName, String inputEmail, String inputPw, String inputPw2) {
        this.inputName = inputName;
        this.inputEmail = inputEmail;
        this.inputPw = inputPw;
        this.inputPw2 = inputPw2;
    }

    public Member toEntity(){
        return Member.builder()
                .username(inputName)
                .email(inputEmail)
                .password(inputPw)
                .joindate(LocalDate.now())
                .build();
    }
}
