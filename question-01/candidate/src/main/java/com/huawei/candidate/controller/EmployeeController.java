package com.huawei.candidate.controller;

import com.huawei.candidate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 *  This question is related with consuming another RESTful microservice with RestTemplate
 *
 *  Problem Description
 *  --------------------
 *  1- This controller class is the client for another microservice which is represented with 'serverUrl' in 'application.properties'
 *  2- With the 'getEmployee()' method, it is required to get employee object by given id from other microservice with RestTemplate.
 *  3- Code the corresponding service with the method name 'getEmployee()' correctly and make it executable.
 *
 *  Sample Request
 *  ---------------
 *  curl -X GET http://localhost:8080/employees/1
 *
 *  Sample Response
 *  ---------------
 *  {"id":1,"fullname":"John Black","department":"IT"}
 *
 */
@RestController
public class EmployeeController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${test.server.url}")
    private String serverUrl;

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = restTemplate.getForObject(serverUrl + "/employees/" + id, Employee.class);
        return employee;
    }
}
