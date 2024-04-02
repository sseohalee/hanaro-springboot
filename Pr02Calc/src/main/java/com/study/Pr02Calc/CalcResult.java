package com.study.Pr02Calc;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CalcResult {
    private int number1;
    private int number2;
    private int result;

    public void plus(int number1, int number2){
        this.number1=number1;
        this.number2=number2;
        this.result=number1+number2;
    }
    public void minus(int number1, int number2){
        this.number1=number1;
        this.number2=number2;
        this.result=number1-number2;
    }
    public void multi(int number1, int number2){
        this.number1=number1;
        this.number2=number2;
        this.result=number1*number2;
    }

    public void divi(int number1, int number2){
        this.number1=number1;
        this.number2=number2;
        this.result=number1/number2;
    }
}
