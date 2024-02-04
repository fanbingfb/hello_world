package com.fb;

public class Manager extends Employee {
    private String message;

    public Manager() {
        super();
    }

    public Manager(String name, Integer age, Double salary, String message) {
        super(name, age, salary);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        new Manager().getName();
    }
}
