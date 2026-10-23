package com.ppra.interview.controller;

import com.ppra.interview.DTO.DepartmentsDto;
import com.ppra.interview.model.Departments;
import com.ppra.interview.service.DepartmentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class Crudecontroller {
    private final DepartmentsService departmentsService;
    public Crudecontroller(DepartmentsService departmentsService){
        this.departmentsService=departmentsService;
    }
    @GetMapping("/departments")
    public List<Departments> myData(){
        return departmentsService.getAllData();
    }
    @GetMapping("/departments/{id}")
    public Departments findDep(@PathVariable long id){
        return departmentsService.getNameByIdMethod(id);
    }
    @GetMapping("/location")
    public Optional<Departments> findLocation(@RequestParam String location){
        return departmentsService.searchByLocation(location);
    }
    @PostMapping("/save")
    public Departments sameController(@RequestBody DepartmentsDto departmentsDto){
        return departmentsService.saveData(departmentsDto);
    }
    @PutMapping("/update/{id}")
    public Departments update(@PathVariable Long id,@RequestBody DepartmentsDto departmentsDto){
        //return departmentsService.updateUserDetails(id,departmentsDto);
        return departmentsService.updateUserDetailsTwo(id,departmentsDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteMethod(@PathVariable long id){
        departmentsService.deleteByID(id);
    }
    @PatchMapping("/patch/{id}")
    public Departments patchController(@PathVariable Long id, @RequestBody DepartmentsDto departmentsDto){
        return departmentsService.patchServiceMethod(id,departmentsDto);
    }





}
