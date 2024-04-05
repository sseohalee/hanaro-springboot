package com.study.Pr11VMDB.entity;

import com.study.Pr11VMDB.dto.ProductSaveDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name="product")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class  Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name; // 상품명
    @Column(name = "price")
    private int price; // 가격
    @Column(name = "limit_date")
    private LocalDate limit_date; // 유통기한

    public ProductSaveDto toSaveDto(){
        return ProductSaveDto.builder()
                .id(id)
                .name(name)
                .price(price)
                .limit_date(limit_date)
                .build();
    }
}

