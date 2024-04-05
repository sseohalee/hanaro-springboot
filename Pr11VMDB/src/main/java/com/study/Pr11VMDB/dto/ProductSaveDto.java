package com.study.Pr11VMDB.dto;

import com.study.Pr11VMDB.entity.Product;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductSaveDto {
    private Long id;
    private String name;
    private int price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate limit_date;

    public Product toSaveEntity(){
        return Product.builder()
                .name(name)
                .price(price)
                .limit_date(limit_date)
                .build();
    }

    public Product toUpdateEntity(){
        return Product.builder()
                .id(id)
                .name(name)
                .price(price)
                .limit_date(limit_date)
                .build();
    }
}
