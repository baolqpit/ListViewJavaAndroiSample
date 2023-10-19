package com.example.week2.Employee;

public abstract class Employee {
    final String id;
    final String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract String calSalary();
    public abstract String toString();
}
