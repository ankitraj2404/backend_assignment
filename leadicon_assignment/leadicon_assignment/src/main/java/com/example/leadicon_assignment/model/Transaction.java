package com.example.leadicon_assignment.model;

public class Transaction {
    private int id;
    private double amount;
    private String type;
    private String category;

    public Transaction() {
    }

    public Transaction(int id, double amount, String type, String category) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transactional{" +
                "id=" + id +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
