package com.ppra.interview.service;

import com.ppra.interview.DTO.DepartmentsDto;
import com.ppra.interview.Repository.DepRepo;
import com.ppra.interview.model.Departments;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentsService {
    private final DepRepo repos;

    public DepartmentsService(DepRepo repos) {
        this.repos = repos;
    }

    public List<Departments> getAllData() {
        return repos.findAll();
    }

    @Cacheable(value="Departments", key = "#number")
    public Departments getNameByIdMethod(long number) {
        return repos.findById(number).orElseThrow(()->new RuntimeException("user not found"));
    }

    public Optional<Departments> searchByLocation(String name) {
        return repos.findByLocation(name);
    }

    public Departments saveData(DepartmentsDto departmentsDto) {
        Departments d = new Departments();
        d.setName(departmentsDto.getName());
        d.setLocation(departmentsDto.getLocation());
        return repos.save(d);
    }

    public Departments updateUserDetails(Long id, DepartmentsDto departmentsDto) {
        Departments departments = repos.findById(id).orElseThrow(()->new RuntimeException("Deprtment not found with id :" + id));
        departments.setName(departmentsDto.getName());
        departments.setLocation(departmentsDto.getLocation());
        return repos.save(departments);

    }
    public Departments updateUserDetailsTwo(Long id, DepartmentsDto departmentsDto){
        Departments departments = repos.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
        departments.setLocation(departmentsDto.getLocation());
        departments.setName(departmentsDto.getName());
        return repos.save(departments);
    }

    public void deleteByID(Long id){
        repos.deleteById(id);
        System.out.println("user deleted");
    }
    public Departments patchServiceMethod(Long id, DepartmentsDto departmentsDto){
        Departments departments = repos.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
        if (departmentsDto.getName() !=null){
            departments.setName(departmentsDto.getName());
        }
        if (departmentsDto.getLocation() !=null){
            departments.setLocation(departmentsDto.getLocation());
        }
        return repos.save(departments);
    }

}
