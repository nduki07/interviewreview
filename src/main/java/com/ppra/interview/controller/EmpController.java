package com.ppra.interview.controller;

import com.ppra.interview.model.Employees;
import com.ppra.interview.service.EmployeesService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/v1")
public class EmpController {
    private final EmployeesService employeesService;
    public EmpController(EmployeesService employeesService){
        this.employeesService=employeesService;
    }
    @GetMapping("/bonus")
    public Set<Employees> empMethod(@Param("bonus") int bonus, @Param("salary") int salary){
        return employeesService.getEmployees(bonus,salary);
    }
    @GetMapping("/minsalary")
    public Set<String> minSalary(){
        return employeesService.minSalaryMethod();
    }
}
