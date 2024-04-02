package com.study.Pr08LoginJoinAPI.web.dto;

import lombok.Data;

@Data
public class MemberResDto {
    private String status;
    private String message;

    public MemberResDto() {
    }

    public MemberResDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
