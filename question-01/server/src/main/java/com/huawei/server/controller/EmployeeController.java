package com.huawei.server.controller;

import com.huawei.server.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return findEmployeeByID(id);
    }

    private Employee findEmployeeByID(int id) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John Black", "IT"),
                new Employee(2, "Steve White", "HR"),
                new Employee(3, "Sophia Green", "Finance")
        );
        return employees.get(id - 1);
    }
}
