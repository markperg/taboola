package com.example.calculator.variables;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VariablesController {

    private Map<String, Integer> variables;
    private List<VariablesEvent> preEvaluationEvents;
    private List<VariablesEvent> postEvaluationEvents;

    public VariablesController(){
        this.variables = new HashMap<>();
        this.preEvaluationEvents = new ArrayList<>();
        this.postEvaluationEvents = new ArrayList<>();
    }


    public Integer getVariable(String name){
        return this.variables.get(name);
    }

    public void setVariable(String name, Integer value){
        this.variables.put(name, value);
    }

    public void deleteVariable(String name){
        this.variables.remove(name);
    }

    public boolean isExists(String name){
        return this.variables.containsKey(name);
    }

    public void addNew(String name){
        this.variables.put(name, 0);
    }

    public Map<String, Integer> getMap(){
        return this.variables;
    }


    public void addAfterEvaluationEvent(VariablesEvent event) {
        this.postEvaluationEvents.add(event);
    }

    public void addBeforeEvaluationEvent(VariablesEvent event) {
        this.preEvaluationEvents.add(event);
    }

    public void clearLists(){
        this.preEvaluationEvents = new ArrayList<>();
        this.postEvaluationEvents = new ArrayList<>();
    }

    public void executePreEvaluationLogic() {
        for(VariablesEvent event : preEvaluationEvents){
            handleEvent(event);
        }
    }

    public void executePostEvaluationLogic() {
        for(VariablesEvent event : postEvaluationEvents){
            handleEvent(event);
        }
    }

    private void handleEvent(VariablesEvent event){
        String key = event.getName();
        Integer value = variables.get(key);

        if(event.getAction().equals(VariablesActions.DECREMENT)){
            variables.put(key, --value);
        } else if (event.getAction().equals(VariablesActions.INCREMENT)){
            variables.put(key, ++value);
        }
    }
}
