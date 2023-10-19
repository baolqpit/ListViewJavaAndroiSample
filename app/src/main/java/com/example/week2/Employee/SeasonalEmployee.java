package com.example.week2.Employee;

public class SeasonalEmployee extends Employee{

    public SeasonalEmployee(String id, String name) {
        super(id, name);
    }

    @Override
    public String calSalary() {
        return "10.000.000";
    }

    @Override
    public String toString() {
        return "------Seasonal Employee------\n Id: " + id + "\nName: " + name + "\nSalary: " + calSalary();
    }
}
