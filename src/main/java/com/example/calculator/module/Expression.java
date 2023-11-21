package com.example.calculator.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Expression holder container that is used to represent expression as an Object
 */
public class Expression {

    private String targetVariable;
    private AssignmentType assignmentType;
    private List<String> parts;

    public Expression(String targetVariable, AssignmentType assignmentType, List<String> parts){
        this.targetVariable = targetVariable;
        this.assignmentType = assignmentType;
        this.parts = parts;
    }

    public Expression(String targetVariable, String assignmentType, List<String> parts){
        this(targetVariable, AssignmentType.fromString(assignmentType), parts);
    }

    public String getTargetVariable() {
        return targetVariable;
    }

    public void setTargetVariable(String targetVariable) {
        this.targetVariable = targetVariable;
    }

    public AssignmentType getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(AssignmentType assignmentType) {
        this.assignmentType = assignmentType;
    }

    public List<String> getParts() {
        return parts;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }

    public static Expression fromStringArray(String[] expressionArray){
        List<String> expression =  new ArrayList<>(Arrays.asList(expressionArray));
        String variableName = expression.get(0);
        expression.remove(0);
        AssignmentType assignmentType = AssignmentType.fromString(expression.get(0));
        expression.remove(0);
        Expression result = new Expression(variableName, assignmentType, expression);
        return result;
    }

}
