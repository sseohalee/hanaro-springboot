package com.study.Pr10MemberAdminAPI.web.dto;

import lombok.Data;

@Data
public class MemberResDto {
    private String status;
    private String message;
    private int access = 0;

    public MemberResDto() {
    }

    public MemberResDto(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public MemberResDto(String status, String message, int access) {
        this.status = status;
        this.message = message;
        this.access = access;
    }
}
