package com.ppra.interview.Repository;

import com.ppra.interview.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface EmpRepo extends JpaRepository<Employees,Long> {
    //bonus > 10k and salary >150k
    @Query("SELECT e FROM Employees e WHERE e.bonus > :bonus AND e.salary > :salary ORDER BY e.salary ASC")
    Set<Employees> findByBonusAndSalary(@Param("bonus") int bonus, @Param("salary") int salary);

    @Query("SELECT MIN(e.salary)FROM Employees e GROUP BY e.full_name")
    Set<String> findByMinSalary();
}
