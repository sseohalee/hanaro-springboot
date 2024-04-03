package com.study.Pr10MemberAdminAPI.web.dto;

import lombok.Data;

@Data
public class LoginReqDto {
    private String inputName;
    private String inputPw;

    public LoginReqDto(String inputName, String inputPw) {
        this.inputName = inputName;
        this.inputPw = inputPw;
    }
}
