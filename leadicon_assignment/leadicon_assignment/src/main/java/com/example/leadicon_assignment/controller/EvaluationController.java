package com.example.leadicon_assignment.controller;

import com.example.leadicon_assignment.model.Transaction;
import com.example.leadicon_assignment.service.RuleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/evaluate")
@AllArgsConstructor
public class EvaluationController {

    private final RuleService ruleService;

    // ======================================================
    //METHOD:- POST
    //ENDPOINT:- http://localhost:8080/evaluate
    //PURPOSE:- Evaluating the transactions
    // ======================================================
    @PostMapping("/evaluate")
    public List<Transaction> evaluate(@RequestBody List<Transaction> transactions) {
        return ruleService.evaluateTransactions(transactions);
    }
}
