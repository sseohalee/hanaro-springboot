package com.study.Pr06VMAPI.service.product;

import com.study.Pr06VMAPI.domain.product.Product;
import com.study.Pr06VMAPI.web.dto.ProductAddRequestDto;
import com.study.Pr06VMAPI.web.dto.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
//    public static List<Product> productList = new ArrayList<Product>();
    public ProductResponseDto add(ProductAddRequestDto reqDto){
        Product product = Product.builder()
                        .name(reqDto.getName())
                        .price(Integer.parseInt(reqDto.getPrice()))
                        .limit_date(reqDto.getLimit_date()).build();
//        new Product(pdName,Integer.parseInt(pdPrice),pdLimitDate)
//        productList.add(product);

        return new ProductResponseDto("1");
    }
}
