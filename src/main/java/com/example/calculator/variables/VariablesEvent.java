package com.example.calculator.variables;

public class VariablesEvent {

    private String name;
    private VariablesActions action;

    public VariablesEvent(String name, VariablesActions action){
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VariablesActions getAction() {
        return action;
    }

    public void setAction(VariablesActions action) {
        this.action = action;
    }

}
