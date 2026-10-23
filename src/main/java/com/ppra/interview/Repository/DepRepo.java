package com.ppra.interview.Repository;

import com.ppra.interview.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepRepo extends JpaRepository<Departments, Long> {
    Optional<Departments>findByLocation(String Location);

}
