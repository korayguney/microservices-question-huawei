package com.huawei.candidate.controller;

import com.huawei.candidate.model.Employee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest
public class EmployeeControllerTest {

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void getEmployeeTest() {

        Employee employee = restTemplate.getForObject("http://localhost:8081/employees/1", Employee.class);

        assertAll(
                () -> assertEquals(1, employee.getId()),
                () -> assertEquals("John Black", employee.getFullname()),
                () -> assertEquals("IT", employee.getDepartment())
        );
    }
}