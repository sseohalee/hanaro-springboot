package com.study.Pr06VMAPI.web;

import com.study.Pr06VMAPI.domain.product.Product;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String main(Model model){
        System.out.println(ProductController.productList);
        model.addAttribute("productList", ProductController.productList);
        model.addAttribute("listLength", ProductController.productList.size());
        return "index";
    }

    // 상품 추가
    @GetMapping("/add")
    public String productAdd(Model model){
        return "product-add";
    }

    // 상품 수정
    @GetMapping("/update")
    public String updateProduct(@RequestParam String index,
                                Model model){
        Product product = ProductController.productList.get(Integer.parseInt(index));
        model.addAttribute("pdName", product.getName());
        model.addAttribute("pdPrice", product.getPrice());
        model.addAttribute("pdLimitDate", product.getLimit_date());
        model.addAttribute("index", index);

        return "product-update";
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
