package com.study.Pr11VMDB.controller;

import com.study.Pr11VMDB.dto.ProductSaveDto;
import com.study.Pr11VMDB.entity.Product;
import com.study.Pr11VMDB.entity.ProductRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class MainController {

    final ProductRepository productRepository;

    @GetMapping("/")
    public String main(Model model){
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("listLength", productRepository.count());
        return "index";
    }

    // 상품 추가 ---------------------------
    @GetMapping("/add")
    public String add(){
        return "product-add";
    }

    @PostMapping("/add-action")
    @ResponseBody
    public String addAction(@ModelAttribute ProductSaveDto dto){
        try{
            Product product = dto.toSaveEntity();
            productRepository.save(product);
        }
        catch (Exception e){
            e.printStackTrace();
            return "<script>alert('상품 등록 실패'); history.back();</script>";
        }
        return "<script>alert('상품 등록 성공'); location.href='/';</script>";
    }

    // 상품 수정 ------------------------------------
    @GetMapping("/update")
    public String updateProduct(@RequestParam int id,
                                Model model){
        Optional<Product> optional = productRepository.findById((long)id);
        if(!optional.isPresent()){
            return "/";
        }
        optional.ifPresent( product -> {
            model.addAttribute( "product", product.toSaveDto());
        });

        return "product-update";
    }

    @PostMapping("/update-action")
    @ResponseBody
    public String update(@ModelAttribute ProductSaveDto dto){
        try{
            Product product = dto.toUpdateEntity();
            productRepository.save(product);
        } catch (Exception e){
            e.printStackTrace();
            return "<script>alert('상품 정보 수정 실패'); history.back();</script>";
        }

        return "<script>alert('상품 정보 수정 완료'); location.href='/';</script>";
    }

    // 상품 삭제 -------------------------------
    @GetMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam int id){
        Optional<Product> optional = productRepository.findById((long)id);
        if( !optional.isPresent() ){
            return "<script>alert('상품정보조회 실패');history.back();</script>";
        }
        Product product = optional.get();
        try{
            productRepository.delete(product);
        } catch(Exception e){
            e.printStackTrace();
            return "<script>alert('상품 삭제 실패하였습니다.'); history.back();</script>";
        }

        return "<script>alert('상품 삭제 성공하였습니다.'); location.href='/';</script>";
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
