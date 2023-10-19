package com.example.week2.Employee;

public class Official extends Employee{


    public Official(String id, String name) {
        super(id, name);
    }

    @Override
    public String calSalary() {
        return "20.000.000";
    }

    @Override
    public String toString() {
        return "------Official Employee------\n Id: " + id + "\nName: " + name + "\nSalary: " + calSalary();
    }
}