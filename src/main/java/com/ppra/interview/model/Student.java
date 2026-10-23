package com.ppra.interview.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

}
