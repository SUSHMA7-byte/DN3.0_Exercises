package com.sushma.Employee.Repository;

import com.sushma.Employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Using the named query defined in Employee entity
    @Query(name = "Employee.findByEmail")
    Employee findByEmailNamedQuery(@Param("email") String email);
}
