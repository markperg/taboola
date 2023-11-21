package com.example.calculator.variables;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Resolver class that handles post and pre evaluation operations
 */
public class VariableResolver {

    /**
     * Resolves pre- and post-increment/decrement operations in a given list of expressions.
     * Iterates through each expression and applies increment or decrement operations on variables.
     * Supports both pre- and post-operations. For post-operations (e.g., 'a++' or 'b--'),
     * the event is added to be executed after the main evaluation. For pre-operations
     * (e.g., '++a' or '--b'), the event is added to be executed before the main evaluation.
     * The resolved expression, with the operation removed, replaces the original in the list.
     *
     * @param expression    List of string expressions to be resolved.
     * @param controller    Controller responsible for managing variable events and states.
     */
    public void resolve(List<String> expression, VariablesController controller){

        for(int i = 0; i < expression.size(); i++) {
            if(Pattern.matches("[a-z]\\+\\+", expression.get(i))){
                String resolvedVariable = expression.get(i).replace("++", "");
                controller.addAfterEvaluationEvent(new VariablesEvent(resolvedVariable,
                                VariablesActions.INCREMENT));
                expression.set(i, resolvedVariable);
                continue;
            }

            if(Pattern.matches("[a-z]\\-\\-", expression.get(i))){
                String resolvedVariable = expression.get(i).replace("--", "");
                controller.addAfterEvaluationEvent(
                        new VariablesEvent(resolvedVariable,
                                VariablesActions.DECREMENT));
                expression.set(i, resolvedVariable);
                continue;
            }

            if(Pattern.matches("\\+\\+[a-z]", expression.get(i))){
                String resolvedVariable = expression.get(i).replace("++", "");
                controller.addBeforeEvaluationEvent(
                        new VariablesEvent(resolvedVariable,
                                VariablesActions.INCREMENT));
                expression.set(i, resolvedVariable);
                continue;
            }

            if(Pattern.matches("\\-\\-[a-z]", expression.get(i))){
                String resolvedVariable = expression.get(i).replace("--", "");
                controller.addBeforeEvaluationEvent(
                        new VariablesEvent(resolvedVariable,
                                VariablesActions.DECREMENT));
                expression.set(i, resolvedVariable);
                continue;
            }
        }
    }
}
