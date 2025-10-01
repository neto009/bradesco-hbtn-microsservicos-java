package com.example.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem-vindo à API Calculator!", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        RequestBuilder request = get("/calculator/addNumbers")
            .param("number1", "5.0")
            .param("number2", "3.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("A soma de 5.0 + 3.0 = 8.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {
        RequestBuilder request = get("/calculator/subNumbers")
            .param("number1", "10.0")
            .param("number2", "4.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("A subtração de 10.0 - 4.0 = 6.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {
        RequestBuilder request = get("/calculator/divideNumbers")
            .param("number1", "15.0")
            .param("number2", "3.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("A divisão de 15.0 / 3.0 = 5.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbersByZero() throws Exception {
        RequestBuilder request = get("/calculator/divideNumbers")
            .param("number1", "10.0")
            .param("number2", "0.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Erro: Divisão por zero não é permitido.", result.getResponse().getContentAsString());
    }

    @Test
    void factorial() throws Exception {
        RequestBuilder request = get("/calculator/factorial")
            .param("factorial", "5");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("O fatorial de 5 = 120", result.getResponse().getContentAsString());
    }

    @Test
    void factorialZero() throws Exception {
        RequestBuilder request = get("/calculator/factorial")
            .param("factorial", "0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("O fatorial de 0 = 1", result.getResponse().getContentAsString());
    }

    @Test
    void factorialNegative() throws Exception {
        RequestBuilder request = get("/calculator/factorial")
            .param("factorial", "-1");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Erro: Fatorial não pode ser calculado para números negativos.", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        RequestBuilder request = get("/calculator/calculeDayBetweenDate")
            .param("localDate1", "2023-01-01")
            .param("localDate2", "2023-01-15");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("A diferença entre 2023-01-01 e 2023-01-15 é de 14 dias", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDateReverse() throws Exception {
        RequestBuilder request = get("/calculator/calculeDayBetweenDate")
            .param("localDate1", "2023-01-15")
            .param("localDate2", "2023-01-01");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("A diferença entre 2023-01-15 e 2023-01-01 é de 14 dias", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        RequestBuilder request = get("/calculator/integerToBinary")
            .param("number1", "5");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("O número 5 em binário é: 101", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinaryZero() throws Exception {
        RequestBuilder request = get("/calculator/integerToBinary")
            .param("number1", "0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("O número 0 em binário é: 0", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        RequestBuilder request = get("/calculator/integerToHexadecimal")
            .param("number1", "255");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("O número 255 em hexadecimal é: FF", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimalSmall() throws Exception {
        RequestBuilder request = get("/calculator/integerToHexadecimal")
            .param("number1", "10");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("O número 10 em hexadecimal é: A", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbersWithNull() throws Exception {
        RequestBuilder request = get("/calculator/addNumbers")
            .param("number2", "3.0");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Erro: Número 1 e número 2 são obrigatórios.", result.getResponse().getContentAsString());
    }
}