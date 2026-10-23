package com.ppra.interview.service;

import com.ppra.interview.DTO.StudentDto;
import com.ppra.interview.Repository.SchoolRepo;
import com.ppra.interview.Repository.StudentRepo;
import com.ppra.interview.model.School;
import com.ppra.interview.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepo studentRepo;
    private final SchoolRepo schoolRepo;
    public StudentService(StudentRepo studentRepo,SchoolRepo schoolRepo){
        this.studentRepo = studentRepo;
        this.schoolRepo =schoolRepo;
    }
    public Student saveStudentMethod(StudentDto studentDto){
        Student student = new Student();
        student.setFirst_name(studentDto.getFirst_name());
        School school =schoolRepo.findById(studentDto.getSchoolId()).orElseThrow(()->new RuntimeException("SCHOOL ID NOT FOUND"));
        student.setSchool(school);
        return studentRepo.save(student);
    }
}
