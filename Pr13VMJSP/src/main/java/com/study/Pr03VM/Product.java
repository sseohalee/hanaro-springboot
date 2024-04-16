package com.study.Pr03VM;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Product {
    private String name; // 상품명
    private int price; // 가격
    private LocalDate limit_date; // 유통기한
}
