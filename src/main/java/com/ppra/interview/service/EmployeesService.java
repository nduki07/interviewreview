package com.ppra.interview.service;

import com.ppra.interview.Repository.EmpRepo;
import com.ppra.interview.model.Employees;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class EmployeesService {
    private  final EmpRepo empRepo;
    public EmployeesService(EmpRepo empRepo){
        this.empRepo=empRepo;
    }

    @Cacheable(value = "Employees", key="#bonus + '-'+ #salary")
    public Set<Employees> getEmployees(int bonus, int salary){
        return empRepo.findByBonusAndSalary(bonus,salary);
    }
    public Set<String> minSalaryMethod(){
        return empRepo.findByMinSalary();
    }

}
