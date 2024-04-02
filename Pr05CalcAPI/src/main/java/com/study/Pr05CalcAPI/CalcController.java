package com.study.Pr05CalcAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.study.Pr05CalcAPI.Calculator;

@RestController
@RequiredArgsConstructor // 이거 추가하기
@RequestMapping("/api/v1")
public class CalcController {
    final Calculator calculator;
    @PostMapping("/calc")
    public CalcResDto calc(@RequestBody CalcReqDto reqDto){
        double result = calculator.calc(reqDto);

        CalcResDto calcResDto = new CalcResDto();
        calcResDto.setResult(result);
        return calcResDto;
    }
}
