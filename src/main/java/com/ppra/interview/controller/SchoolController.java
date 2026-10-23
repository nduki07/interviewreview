package com.ppra.interview.controller;

import com.ppra.interview.DTO.SchoolDto;
import com.ppra.interview.model.School;
import com.ppra.interview.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SchoolController {
    private final SchoolService schoolService;
    public SchoolController(SchoolService schoolService){
        this.schoolService=schoolService;
    }
    @PostMapping("/school/save")
    public ResponseEntity<School> saveSchool(@RequestBody SchoolDto schoolDto){
        School school = schoolService.saveSchoolMethod(schoolDto);
        return ResponseEntity.status(HttpStatus.OK).body(school);
    }
}
