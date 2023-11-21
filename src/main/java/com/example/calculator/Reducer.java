package com.example.calculator;

import com.example.calculator.module.Logic;
import com.example.calculator.variables.VariablesController;

import java.util.List;
import java.util.regex.Pattern;

public class Reducer {


    public void reduceByMultiplication(List<String> elements){
        genericReducer(elements, Logic.MULTIPLICATION);
    }

    public void reduceByDivision(List<String> elements){
        genericReducer(elements, Logic.DIVISION);
    }

    public void reduceBySubtraction(List<String> elements){
        genericReducer(elements, Logic.SUBTRACTION);
    }

    public void reduceByAddition(List<String> elements){
        genericReducer(elements, Logic.ADDITION);
    }

    private void genericReducer(List<String> elements, Logic logic){
        for(int i = 0; i < elements.size(); i++){

                Integer calculatedValue = null;
                switch(logic){
                    case MULTIPLICATION:
                        if(isMultiplication(elements.get(i))){
                            Integer left = Integer.valueOf(elements.get(i - 1));
                            Integer right = Integer.valueOf(elements.get(i + 1));
                            calculatedValue = left * right;
                        }
                        break;
                    case DIVISION:
                        if(isDivision(elements.get(i))){
                            Integer left = Integer.valueOf(elements.get(i - 1));
                            Integer right = Integer.valueOf(elements.get(i + 1));
                            calculatedValue = left / right;
                        }
                        break;
                    case SUBTRACTION:
                        if(isSubstraction(elements.get(i))){
                            Integer left = Integer.valueOf(elements.get(i - 1));
                            Integer right = Integer.valueOf(elements.get(i + 1));
                            calculatedValue = left - right;
                        }
                        break;
                    case ADDITION:
                        if(isAddition(elements.get(i))){
                            Integer left = Integer.valueOf(elements.get(i - 1));
                            Integer right = Integer.valueOf(elements.get(i + 1));
                            calculatedValue = left + right;
                        }
                        break;
                }

                if(calculatedValue != null){
                    elements.set(i-1,calculatedValue.toString());
                    elements.remove(i + 1);
                    elements.remove(i);
                    i--;
                }

            }

    }

    private boolean isAddition(String value) {
        return value.equals("+");
    }

    private boolean isSubstraction(String value) {
        return value.equals("-");
    }

    private boolean isMultiplication(String value) {
        return value.equals("*");
    }

    private boolean isDivision(String value) {
        return value.equals("/");
    }

}

