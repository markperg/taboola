package com.example.calculator.mathematical;

import com.example.calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ComplexOperationsTest {

    @Autowired
    private Calculator calculator;

    @Test
    void complexOperationsFirstTest() {
        Map<String, Integer> results;

        calculator.evaluate("i = 5 + 5 * 8");
        results = calculator.getResultsAsMap();
        assertThat(results.get("i")).isEqualTo(new Integer(45));

    }

    @Test
    void complexOperationsSecondTest() {
        Map<String, Integer> results;

        calculator.evaluate("i = 5 * 8 + 5");
        results = calculator.getResultsAsMap();
        assertThat(results.get("i")).isEqualTo(new Integer(45));

    }

    @Test
    void complexOperationsThirdTest() {
        Map<String, Integer> results;

        calculator.evaluate("i = 5 + 5 * 8 - 5");
        results = calculator.getResultsAsMap();
        assertThat(results.get("i")).isEqualTo(new Integer(40));

    }
}
