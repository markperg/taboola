package com.example.calculator;

import com.example.calculator.module.AssignmentType;
import com.example.calculator.module.Expression;
import com.example.calculator.variables.VariableResolver;
import com.example.calculator.variables.VariablesController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class Calculator {

    @Autowired
    private VariablesController variablesController;

    public void evaluate(String expressionString){
        Expression expression = Expression.fromStringArray(expressionString.split(" "));


        VariableResolver variableResolver = new VariableResolver();
        variableResolver.resolve(expression.getParts(), variablesController);

        // Running pre execution logic
        variablesController.executePreEvaluationLogic();

        // Resolve variable values
        resolveVariableValues(expression.getParts());

        // Running main logic
        Reducer reducer = new Reducer();
        reducer.reduceByMultiplication(expression.getParts());
        reducer.reduceByDivision(expression.getParts());
        reducer.reduceBySubtraction(expression.getParts());
        reducer.reduceByAddition(expression.getParts());

        // Running post execution logic
        variablesController.executePostEvaluationLogic();

        Integer result = Integer.valueOf(expression.getParts().get(0));

        // Running assignment
        handleAssignment(expression.getTargetVariable(), expression.getAssignmentType(), result);

        //Finilizing
        variablesController.clearLists();
    }

    public String getResults(){
        StringBuilder results = new StringBuilder();
        results.append("(");
        for(String key : variablesController.getMap().keySet()){
            results.append(key);
            results.append("=");
            results.append(variablesController.getVariable(key));
            results.append(",");
        }
        results.deleteCharAt(results.length() - 1);
        results.append(")");

        return results.toString();
    }

    public Map<String, Integer> getResultsAsMap(){
        return variablesController.getMap();
    }


    private void handleAssignment(String variable, AssignmentType assignmentType, Integer value){
        if(assignmentType.equals(AssignmentType.SET)){
            variablesController.setVariable(variable, value);
        } else if(assignmentType.equals(AssignmentType.INCREMENT_AND_SET)) {
            Integer newValue = variablesController.getVariable(variable);
            newValue += value;
            variablesController.setVariable(variable, newValue);
        } else if(assignmentType.equals(AssignmentType.DECREMENT_AND_SET)){
            Integer newValue = variablesController.getVariable(variable);
            newValue -= value;
            variablesController.setVariable(variable, newValue);
        }
    }

    private void resolveVariableValues(List<String> expression){
        for(int i = 0; i < expression.size(); i++){
            if(Pattern.matches("[a-z]", expression.get(i))){
                Integer resolvedValue = variablesController.getVariable(expression.get(i));
                expression.set(i, resolvedValue.toString());
            }
        }
    }
}
