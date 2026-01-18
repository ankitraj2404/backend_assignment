# Rule Engine API – Spring Boot Backend Assignment

##  Project Overview

This project is a **Spring Boot–based Rule Engine API** that evaluates financial transactions against **dynamically configurable rules**.

The goal of this application is to allow rules to be:

* Added dynamically at runtime
* Stored in memory (no database)
* Evaluated against incoming transactions without hardcoded conditions

The rule evaluation is done using a **JavaScript engine (Nashorn)** to support dynamic expressions.

---

##  Assignment Objective

Build a backend system that:

* Accepts dynamic rules like
  `amount > 1000 && type.equals("credit")`
* Evaluates transactions against these rules
* Returns transactions that match **at least one rule**

---

##  Technologies Used

* Java 21
* Spring Boot
* Nashorn JavaScript Engine
* Maven
* REST APIs
* Postman (for testing)

---

##  Project Structure

```
com.example.leadicon_assignment
│
├── controller
│   ├── RuleController.java
│   └── EvaluationController.java
│
├── service
│   └── RuleService.java
│
├── model
│   ├── Transaction.java
│   └── Rule.java
│
├── util
│   └── RuleEvaluator.java
│
├── exception
│   └── RuleEvaluationException.java
│
└── LeadiconAssignmentApplication.java
```

---

##  API Endpoints

### 1️ Add Rules

**Endpoint**

```
POST /rules/addNewRules
```

**Description**

* Adds one or more rules to the rule engine.
* Rules are stored in memory.

**Request Body**

```json
[
  "amount > 1000 && type.equals(\"credit\")",
  "category.equals(\"grocery\")"
]
```

**Response**

```
Rules added successfully
```

---

### 2️Get All Rules

**Endpoint**

```
GET /rules
```

**Description**

* Returns all currently active rules.

**Response**

```json
[
  "amount > 1000 && type.equals(\"credit\")",
  "category.equals(\"grocery\")"
]
```

---

###  Evaluate Transactions

**Endpoint**

```
POST /evaluate
```

**Description**

* Evaluates a list of transactions against all stored rules.
* Returns transactions that match **at least one rule**.

**Request Body**

```json
[
  {
    "id": 1,
    "amount": 2500,
    "type": "credit",
    "category": "electronics"
  },
  {
    "id": 2,
    "amount": 120,
    "type": "debit",
    "category": "grocery"
  }
]
```

**Response**

```json
[
  {
    "id": 1,
    "amount": 2500,
    "type": "credit",
    "category": "electronics"
  },
  {
    "id": 2,
    "amount": 120,
    "type": "debit",
    "category": "grocery"
  }
]
```

---

##  How Rule Evaluation Works

1. Rules are stored as JavaScript expressions.
2. Each transaction field (amount, type, category, id) is injected into the script engine.
3. The JavaScript engine evaluates the rule dynamically.
4. If **any rule returns true**, the transaction is considered a match.

Example rule:

```
amount > 1000 && type.equals("credit")
```

---

##  Important Note (Java 21 Compatibility)

Java 21 does not include a JavaScript engine by default.
To support dynamic rule evaluation, **Nashorn is added manually**.

### Maven Dependency

```xml
<dependency>
    <groupId>org.openjdk.nashorn</groupId>
    <artifactId>nashorn-core</artifactId>
    <version>15.4</version>
</dependency>
```

---

##  Error Handling

* Invalid rule expressions throw a custom `RuleEvaluationException`
* Prevents application crash due to malformed rules

---

##  Testing

* APIs can be tested using **Postman**
* JSON-based request and response format
* Multiple rules and transactions can be tested easily

---

##  Key Features

✔ Dynamic rule evaluation
✔ No hardcoded conditions
✔ In-memory rule storage
✔ Clean and modular code
✔ Beginner-friendly design
✔ Java 21 compatible

---

## 🧑‍💻 Author

**Ankit Raj**
Backend Developer Assignment – Leadicon Technologies Pvt Ltd

---

##  Future Enhancements (Optional)

* Rule validation before saving
* Swagger/OpenAPI documentation
* Persistent rule storage (database)
* Custom DSL instead of JavaScript
* Unit testing for rule evaluation

---

 *This project demonstrates dynamic rule evaluation using Spring Boot and is designed to be easily extensible and maintainable.*
