package com.study.Pr06VMAPI2;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class RestAPIController {
    public static List<Product> list = new ArrayList<>();

    public RestAPIController(){
        Product product1 = Product.builder()
                .name("소고기버거")
                .price(2000)
                .limit_date(LocalDate.parse("2024-01-01")).build();
        list.add( product1 );
        Product product2 = Product.builder()
                .name("토마토버거")
                .price(3000)
                .limit_date(LocalDate.parse("2024-02-01")).build();
        list.add( product2 );
        Product product3 = Product.builder()
                .name("배추버거")
                .price(4000)
                .limit_date(LocalDate.parse("2024-03-01")).build();
        list.add( product3 );
    }

    @GetMapping("/products")
    public List<Product> products(){
        return list;
    }

    //http://localhost:8080/deleteProduct?index=0
    @DeleteMapping("/deleteProduct")
    public ResDto deleteProduct(@RequestParam int index){
        list.remove( index );

        ResDto dto = ResDto.builder()
                .status("ok").message("삭제되었습니다")
                .count(1).build();

        return dto;
    }
    //fetch("/api/v1/product", {
    //          method: "PUT",
    @PutMapping("/product")
    public ResDto editProduct(@RequestBody EditProductDto dto) {
        System.out.println(dto.getInputName());
        int index = dto.getIndex();

        Product product = Product.builder()
                .name(dto.getInputName())
                .price(dto.getInputPrice())
                .limit_date(dto.getInputLimitDate())
                .build();
        list.set( index, product);

        ResDto resDto = ResDto.builder()
                .status("ok").message("수정되었습니다.")
                .count(1).build();

        return resDto;
    }

    @PostMapping("/product")
    public ResDto addProduct(@RequestBody EditProductDto dto) {
        System.out.println(dto.getInputName());

        Product product = Product.builder()
                .name(dto.getInputName())
                .price(dto.getInputPrice())
                .limit_date(dto.getInputLimitDate())
                .build();
        list.add( product);

        ResDto resDto = ResDto.builder()
                .status("ok").message("추가되었습니다.")
                .count(1).build();

        return resDto;
    }
}
