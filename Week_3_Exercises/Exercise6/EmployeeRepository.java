package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Paginate and sort the list of employees
    Page<Employee> findAll(Pageable pageable);

    // Paginate and sort employees by department name
    Page<Employee> findByDepartment_Name(String departmentName, Pageable pageable);
}
