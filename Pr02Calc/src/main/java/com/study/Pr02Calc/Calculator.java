package com.study.Pr02Calc;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Calculator {
    double result = 0;

    public int add(int a, int b){
        this.result = a + b;
        return (int)result;
    }
    public int sub(int a, int b){
        this.result = a - b;
        return (int)result;
    }
    public int mul(int a, int b){
        this.result = a * b;
        return (int)result;
    }
    public double div(int a, int b){
        this.result = (double)a / (double)b;
        return result;
    }
}