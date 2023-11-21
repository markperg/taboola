package com.example.calculator.assignment;

import com.example.calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AssignmentTest {

    @Autowired
    private Calculator calculator;

    @Test
    void testSet() {
        Map<String, Integer> results;

        calculator.evaluate("j = 10");
        results = calculator.getResultsAsMap();
        assertThat(results.get("j")).isEqualTo(new Integer(10));

        calculator.evaluate("j = 3");
        results = calculator.getResultsAsMap();
        assertThat(results.get("j")).isEqualTo(new Integer(3));

    }

    @Test
    void testSetAndIncrement() {
        Map<String, Integer> results;

        calculator.evaluate("j = 10");
        results = calculator.getResultsAsMap();
        assertThat(results.get("j")).isEqualTo(new Integer(10));

        calculator.evaluate("j += 3");
        results = calculator.getResultsAsMap();
        assertThat(results.get("j")).isEqualTo(new Integer(13));
    }

    @Test
    void testSetAndDecrement() {
        Map<String, Integer> results;

        calculator.evaluate("j = 10");
        results = calculator.getResultsAsMap();
        assertThat(results.get("j")).isEqualTo(new Integer(10));

        calculator.evaluate("j -= 3");
        results = calculator.getResultsAsMap();
        assertThat(results.get("j")).isEqualTo(new Integer(7));
    }
}
