package com.example.calculator.operations;

import com.example.calculator.Calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class PreEvaluationTest {

    @Autowired
    private Calculator calculator;

    @Test
    void testPreIncrement() {
        Map<String, Integer> results;

        calculator.evaluate("i = 10");
        results = calculator.getResultsAsMap();
        assertThat(results.get("i")).isEqualTo(new Integer(10));

        calculator.evaluate("j = ++i");
        results = calculator.getResultsAsMap();
        assertThat(results.get("i")).isEqualTo(new Integer(11));
        assertThat(results.get("j")).isEqualTo(new Integer(11));

    }

    @Test
    void testPreDecrement() {
        Map<String, Integer> results;

        calculator.evaluate("i = 10");
        results = calculator.getResultsAsMap();
        assertThat(results.get("i")).isEqualTo(new Integer(10));

        calculator.evaluate("j = --i");
        results = calculator.getResultsAsMap();
        assertThat(results.get("i")).isEqualTo(new Integer(9));
        assertThat(results.get("j")).isEqualTo(new Integer(9));
    }
}
