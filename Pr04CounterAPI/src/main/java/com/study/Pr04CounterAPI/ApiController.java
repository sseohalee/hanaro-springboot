package com.study.Pr04CounterAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {
    private final Counter counter; //싱글톤
    @PostMapping("/plus")
    public CounterResDto plus(@RequestBody CounterReqDto reqDto){
        if (reqDto.getOp().equals("plus")){
            counter.setCount(counter.getCount()+1);
        }

        CounterResDto resDto = new CounterResDto();
        resDto.setStatus("ok");
        resDto.setResult(counter.getCount());

        return resDto;
    }

    @PostMapping("/minus")
    public CounterResDto minus(@RequestBody CounterReqDto reqDto){
        if (reqDto.getOp().equals("minus")){
            counter.setCount(counter.getCount()-1);
        }

        CounterResDto resDto = new CounterResDto();
        resDto.setStatus("ok");
        resDto.setResult(counter.getCount());

        return resDto;
    }
}
