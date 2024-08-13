import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JPQL Query to find employees by email
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmail(@Param("email") String email);

    // Native SQL Query to find employees by department
    @Query(value = "SELECT * FROM employees e WHERE e.department_id = :departmentId", nativeQuery = true)
    List<Employee> findByDepartmentId(@Param("departmentId") Long departmentId);
}
