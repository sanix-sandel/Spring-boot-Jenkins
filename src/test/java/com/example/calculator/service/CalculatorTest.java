package com.example.calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator=new Calculator();

    @Test
    public void testSum(){
        assertEquals(5, calculator.sum(2,3));
    }
}