package com.study.Pr06VMAPI.web;

import com.study.Pr06VMAPI.domain.product.Product;

import com.study.Pr06VMAPI.service.product.ProductService;
import com.study.Pr06VMAPI.web.dto.ProductAddRequestDto;
import com.study.Pr06VMAPI.web.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    public static List<Product> productList = new ArrayList<Product>();

    @PostMapping("/add")
    public ProductResponseDto add(@RequestBody ProductAddRequestDto reqDto){
        Product product = new Product(reqDto.getName(),Integer.parseInt(reqDto.getPrice()), reqDto.getLimit_date());
        productList.add(product);
        ProductResponseDto productResponseDto = new ProductResponseDto("ok");

        return productResponseDto;
    }
//    private final ProductService productService;

//    @GetMapping("/add")
//    public String add(@RequestParam String pdName,
//                      @RequestParam int pdPrice,
//                      @RequestParam LocalDate pdLimitDate){
//        Product product = Product.builder()
//                        .name(pdName)
//                        .price(pdPrice)
//                        .limit_date(pdLimitDate).build();
////        new Product(pdName,Integer.parseInt(pdPrice),pdLimitDate)
//        productList.add(product);
////        System.out.println(productList);
//        return "redirect:/";
////        return productService.add(reqDto);
//    }
//
//    @GetMapping("/update")
//    public String update(@RequestParam String index,
//                         @RequestParam String pdName,
//                         @RequestParam int pdPrice,
//                         @RequestParam LocalDate pdLimitDate,
//                         Model model){
//        Product product = productList.get(Integer.parseInt(index));
//        product.setName(pdName);
//        product.setPrice(pdPrice);
//        product.setLimit_date(pdLimitDate);
//
//        model.addAttribute("message", "상품이 수정되었습니다!");
//
//        return "redirect:/";
//    }
//
//    // 상품 삭제
//    @GetMapping("/delete")
//    public String delete(@RequestParam String index,
//                         Model model){
//        productList.remove( Integer.parseInt(index) );
//        model.addAttribute("message", "상품이 삭제되었습니다!");
//
//        return "redirect:/";
//    }
}
