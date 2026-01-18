package com.example.leadicon_assignment.service;

import com.example.leadicon_assignment.model.Transaction;
import com.example.leadicon_assignment.util.RuleEvaluator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RuleService {

    private final List<String> rules = new ArrayList<>();

    private final RuleEvaluator ruleEvaluator;

    // For Adding rules
    public void addRules(List<String> newRules) {
        rules.addAll(newRules);
    }

    // For Getting all rules
    public List<String> getRules() {
        return rules;
    }

    // For Evaluating transactions
    public List<Transaction> evaluateTransactions(List<Transaction> transactions) {

        List<Transaction> matchedTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            for (String rule : rules) {
                if (ruleEvaluator.evaluate(rule, transaction)) {
                    matchedTransactions.add(transaction);
                    break;
                }
            }
        }
        return matchedTransactions;
    }
}
