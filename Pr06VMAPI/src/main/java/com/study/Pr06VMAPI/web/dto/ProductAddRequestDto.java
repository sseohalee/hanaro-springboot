package com.study.Pr06VMAPI.web.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductAddRequestDto {
    private String name;
    private String price;
    private LocalDate limit_date;
}
