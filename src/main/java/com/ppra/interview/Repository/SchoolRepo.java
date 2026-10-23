package com.ppra.interview.Repository;

import com.ppra.interview.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School, Long> {
}
