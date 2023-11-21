package com.example.calculator.mathematical;

import com.example.calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BasicOperationsTest {

    @Autowired
    private Calculator calculator;

    @Test
    void basicOperationsTest() {
        Map<String, Integer> results;

        calculator.evaluate("i = 5 + 6 + 7 - 8");
        results = calculator.getResultsAsMap();
        assertThat(results.get("i")).isEqualTo(new Integer(10));

    }
}
