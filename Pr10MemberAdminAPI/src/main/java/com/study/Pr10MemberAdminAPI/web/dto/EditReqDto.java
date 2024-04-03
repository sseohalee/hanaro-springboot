package com.study.Pr10MemberAdminAPI.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.Pr10MemberAdminAPI.domain.Member;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EditReqDto {
    private int index;
    private String inputName;
    private String inputPw;
    private String inputEmail;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joindate;

    public Member toEntity(){
        return Member.builder()
                .username(inputName)
                .email(inputEmail)
                .password(inputPw)
                .joindate(LocalDate.now())
                .build();
    }
}
