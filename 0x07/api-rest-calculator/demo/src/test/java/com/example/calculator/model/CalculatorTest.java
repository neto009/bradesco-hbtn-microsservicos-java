package com.example.calculator.model;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void sumTest() {
        Double result = calculator.sum(5.0, 3.0);
        assertEquals(8.0, result);

        Double result2 = calculator.sum(2.5, 3.7);
        assertEquals(6.2, result2, 0.001);
    }

    @Test
    public void numbersNullSumTest() {
        assertThrows(NullPointerException.class, () -> {
            calculator.sum(null, 5.0);
        });

        assertThrows(NullPointerException.class, () -> {
            calculator.sum(5.0, null);
        });
    }

    @Test
    void subTest() {
        Double result = calculator.sub(10.0, 3.0);
        assertEquals(7.0, result);

        Double result2 = calculator.sub(3.0, 10.0);
        assertEquals(-7.0, result2);
    }

    @Test
    void divideTest() {
        Double result = calculator.divide(10.0, 2.0);
        assertEquals(5.0, result);
        
        Double result2 = calculator.divide(10.0, 3.0);
        assertEquals(3.333333333333333, result2, 0.001);

        Double result3 = calculator.divide(-10.0, 2.0);
        assertEquals(-5.0, result3);
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10.0, 0.0);
        });
        
        assertThrows(NullPointerException.class, () -> {
            calculator.divide(null, 5.0);
        });
        
        assertThrows(NullPointerException.class, () -> {
            calculator.divide(5.0, null);
        });
    }

    @Test
    void factorialTest() {
        assertEquals(1, calculator.factorial(0));
        assertEquals(1, calculator.factorial(1));
        assertEquals(2, calculator.factorial(2));
        assertEquals(6, calculator.factorial(3));
        assertEquals(24, calculator.factorial(4));
        assertEquals(120, calculator.factorial(5));

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(-1);
        });
        
        assertThrows(NullPointerException.class, () -> {
            calculator.factorial(null);
        });
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(1, calculator.integerToBinary(1));
        assertEquals(101, calculator.integerToBinary(5));
        assertEquals(10100, calculator.integerToBinary(20));
        assertEquals(0, calculator.integerToBinary(0));
        assertEquals(1111, calculator.integerToBinary(15));
        
        assertThrows(NullPointerException.class, () -> {
            calculator.integerToBinary(null);
        });
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("1", calculator.integerToHexadecimal(1));
        assertEquals("37", calculator.integerToHexadecimal(55));
        assertEquals("AA", calculator.integerToHexadecimal(170));
        assertEquals("0", calculator.integerToHexadecimal(0));
        assertEquals("FF", calculator.integerToHexadecimal(255));

        assertThrows(NullPointerException.class, () -> {
            calculator.integerToHexadecimal(null);
        });
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 29);
        assertEquals(14, calculator.calculeDayBetweenDate(date1, date2));
        
        assertEquals(14, calculator.calculeDayBetweenDate(date2, date1));

        assertEquals(0, calculator.calculeDayBetweenDate(date1, date1));

        LocalDate date3 = LocalDate.of(2020, 2, 15);
        LocalDate date4 = LocalDate.of(2020, 4, 15);
        assertEquals(60, calculator.calculeDayBetweenDate(date3, date4));

        assertThrows(NullPointerException.class, () -> {
            calculator.calculeDayBetweenDate(null, date1);
        });
        
        assertThrows(NullPointerException.class, () -> {
            calculator.calculeDayBetweenDate(date1, null);
        });
        
        assertThrows(NullPointerException.class, () -> {
            calculator.calculeDayBetweenDate(null, null);
        });
    }
}