package com.ppra.interview.service;

import com.ppra.interview.DTO.SchoolDto;
import com.ppra.interview.Repository.SchoolRepo;
import com.ppra.interview.model.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    private final SchoolRepo schoolRepo;
    public SchoolService(SchoolRepo schoolRepo){
        this.schoolRepo=schoolRepo;
    }
    public School saveSchoolMethod(SchoolDto schoolDto){
        School school =new School();
        school.setName(schoolDto.getName());
        System.out.println("before save : "+ school.getName());
        school = schoolRepo.save(school);
        System.out.println("After save : " + school.getName());
        return school;
    }
}
