package com.sushma.Employee.Repository;

import com.sushma.Employee.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query method
    Department findByName(String name);
}