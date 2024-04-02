package com.study.Pr03VM;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Controller
public class mainController {
    List<Product> productList = new ArrayList<Product>();
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("productList", productList);
        model.addAttribute("listLength", productList.size());
        return "index";
    }

    // 상품 추가
    @GetMapping("/add")
    public String productAdd(Model model){
        model.addAttribute("title", "자판기 상품 추가");
        model.addAttribute("btnMessage", "상품 추가 완료!");
        return "product-add";
    }

    @GetMapping("/add-action")
    public String add(@RequestParam String pdName,
                      @RequestParam String pdPrice,
                      @RequestParam LocalDate pdLimitDate,
                      Model model){
//        Product product = Product.builder()
//                        .name(pdName)
//                        .price(Integer.parseInt(pdPrice))
//                        .limit_date(pdLimitDate).build();

        productList.add(new Product(pdName,Integer.parseInt(pdPrice),pdLimitDate));
        System.out.println(productList);
        model.addAttribute("message", "상품이 추가되었습니다!");
        return "redirect:/";
    }

    // 상품 수정
    @GetMapping("/update")
    public String updateProduct(@RequestParam String index,
                                Model model){
        Product product = productList.get(Integer.parseInt(index));
        model.addAttribute("pdName", product.getName());
        model.addAttribute("pdPrice", product.getPrice());
        model.addAttribute("pdLimitDate", product.getLimit_date());
        model.addAttribute("index", index);

        model.addAttribute("title", "자판기 상품 수정");
        model.addAttribute("btnMessage", "상품 수정 완료!");
        return "product-update";
    }

    @GetMapping("/update-action")
    public String update(@RequestParam String index,
                         @RequestParam String pdName,
                         @RequestParam int pdPrice,
                         @RequestParam LocalDate pdLimitDate,
                         Model model){
        Product product = productList.get(Integer.parseInt(index));
        product.setName(pdName);
        product.setPrice(pdPrice);
        product.setLimit_date(pdLimitDate);

        model.addAttribute("message", "상품이 수정되었습니다!");

        return "redirect:/";
    }

    // 상품 삭제
    @GetMapping("/delete")
    public String delete(@RequestParam String index,
                         Model model){
        productList.remove( Integer.parseInt(index) );
        model.addAttribute("message", "상품이 삭제되었습니다!");

        return "redirect:/";
    }

    @GetMapping("/changeLocale")
    public String changeLocale(HttpSession session){
        Locale locale = (Locale)session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        if(Locale.KOREA.equals(locale)){
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
                    Locale.ENGLISH);
        }else{
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
                    Locale.KOREA);
        }
        return "redirect:/";
    }
}
