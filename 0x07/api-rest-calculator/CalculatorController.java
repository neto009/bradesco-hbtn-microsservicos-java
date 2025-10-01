package com.example.calculator.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculator.model.Calculator;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    private final Calculator calculator = new Calculator();

    @GetMapping("/welcome")
    public String messageWelcome() {
        return "Bem-vindo à API Calculator!";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        try {
            Double result = calculator.sum(n1, n2);
            return "A soma de " + n1 + " + " + n2 + " = " + result;
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        try {
            Double result = calculator.sub(n1, n2);
            return "A subtração de " + n1 + " - " + n2 + " = " + result;
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        try {
            Double result = calculator.divide(n1, n2);
            return "A divisão de " + n1 + " / " + n2 + " = " + result;
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "factorial") Integer factorial) {
        try {
            Integer result = calculator.factorial(factorial);
            return "O fatorial de " + factorial + " = " + result;
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(
            @RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
            @RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {
        try {
            int result = calculator.calculeDayBetweenDate(localDate1, localDate2);
            return "A diferença entre " + localDate1 + " e " + localDate2 + " é de " + result + " dias";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam(name = "number1") Integer n1) {
        try {
            Integer result = calculator.integerToBinary(n1);
            return "O número " + n1 + " em binário é: " + result;
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    @GetMapping("/integerToHexadecimal")
    public String integerToHexadecimal(@RequestParam(name = "number1") Integer n1) {
        try {
            String result = calculator.integerToHexadecimal(n1);
            return "O número " + n1 + " em hexadecimal é: " + result;
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}