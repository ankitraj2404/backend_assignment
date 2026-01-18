package com.example.leadicon_assignment.controller;

import com.example.leadicon_assignment.service.RuleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
@AllArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    // ======================================================
    //METHOD:- POST
    //ENDPOINT:- http://localhost:8080/rules/addingNewRule
    //PURPOSE:- Adding new rule
    // ======================================================
    @PostMapping("/addingNewRule")
    public String addRules(@RequestBody List<String> rules) {
        ruleService.addRules(rules);
        return "Rules added successfully";
    }
    // ======================================================
    //METHOD:- GET
    //ENDPOINT:- http://localhost:8080/rules
    //PURPOSE:- Getting all the rules
    // ======================================================
    @GetMapping
    public List<String> getRules() {
        return ruleService.getRules();
    }
}
