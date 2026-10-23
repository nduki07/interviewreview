package com.ppra.interview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="name cant be empty")
    private String full_name;

    @Email(message = "invalid email format")
    private String email;

    @NotNull(message = "manager id cant be null")
    @Positive(message = "manager id must be a valid positive number")
    private int salary;

    @NotNull(message = "position id cant be null")
    @Positive(message = "bonus must be a valid positive number")
    private int bonus;


}
