package com.example.calculator.main;

import com.example.calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MainTest {

    @Autowired
    private Calculator calculator;

    @Test
    void mainTest() {
        Map<String, Integer> results;

        calculator.evaluate("i = 0");
        calculator.evaluate("j = ++i");
        calculator.evaluate("x = i++ + 5");
        calculator.evaluate("y = 5 + 3 * 10");
        calculator.evaluate("i += y");
        results = calculator.getResultsAsMap();
        assertThat(results.get("i")).isEqualTo(new Integer(37));
        assertThat(results.get("j")).isEqualTo(new Integer(1));
        assertThat(results.get("x")).isEqualTo(new Integer(6));
        assertThat(results.get("y")).isEqualTo(new Integer(35));


    }
}
