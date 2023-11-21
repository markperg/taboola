package com.example.calculator.mathematical;

import com.example.calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OperationsWithVariablesTest {

    @Autowired
    private Calculator calculator;

    @Test
    void operationsWithVariablesTest() {
        Map<String, Integer> results;

        calculator.evaluate("i = 10");
        results = calculator.getResultsAsMap();
        assertThat(results.get("i")).isEqualTo(new Integer(10));

        calculator.evaluate("j = 5 + i + 5");
        results = calculator.getResultsAsMap();
        assertThat(results.get("i")).isEqualTo(new Integer(10));
        assertThat(results.get("j")).isEqualTo(new Integer(20));

    }
}
