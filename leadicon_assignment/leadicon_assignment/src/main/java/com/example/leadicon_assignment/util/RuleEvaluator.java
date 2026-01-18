package com.example.leadicon_assignment.util;

import com.example.leadicon_assignment.exception.RuleEvaluationException;
import com.example.leadicon_assignment.model.Transaction;
import org.springframework.stereotype.Component;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


@Component
public class RuleEvaluator {

    private final ScriptEngine engine;

    public RuleEvaluator() {
        this.engine = new ScriptEngineManager().getEngineByName("nashorn");

        if (this.engine == null) {
            throw new RuntimeException("Nashorn engine not found. Check dependency.");
        }
    }

    public boolean evaluate(String rule, Transaction transaction) {
        try {
            engine.put("id", transaction.getId());
            engine.put("amount", transaction.getAmount());
            engine.put("type", transaction.getType());
            engine.put("category", transaction.getCategory());

            Object result = engine.eval(rule);
            return Boolean.TRUE.equals(result);

        } catch (Exception e) {
            throw new RuleEvaluationException("Invalid rule: " + rule);
        }
    }
}

