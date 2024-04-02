package com.study.Pr06VMAPI.web.dto;

import lombok.Data;

@Data
public class ProductResponseDto {
    private String status;
    public ProductResponseDto(String status) {
        this.status = status;
    }
}
