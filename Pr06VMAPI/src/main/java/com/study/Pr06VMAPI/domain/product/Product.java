package com.study.Pr06VMAPI.domain.product;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Product {
    private String name; // 상품명
    private int price; // 가격
    private LocalDate limit_date; // 유통기한

    public Product(String name, int price, LocalDate limit_date) {
        this.name = name;
        this.price = price;
        this.limit_date = limit_date;
    }
    public void update(String name, int price, LocalDate limit_date){
        this.name = name;
        this.price = price;
        this.limit_date = limit_date;
    }
}
