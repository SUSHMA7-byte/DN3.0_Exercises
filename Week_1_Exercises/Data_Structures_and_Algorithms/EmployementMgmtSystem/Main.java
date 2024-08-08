package Data_Structures_and_Algorithms.EmployementMgmtSystem;

public class Main {

    static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "employeeId=" + employeeId +
                    ", name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    private Employee[] employees;
    private int size;

    public Main(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Employee array is full.");
        }
    }

    // Search for an employee by ID
    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and display all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public void deleteEmployeeById(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[size - 1] = null;
            size--;
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        Main ems = new Main(5);

        // Add employees
        ems.addEmployee(new Employee(1, "Alice", "Developer", 70000));
        ems.addEmployee(new Employee(2, "Bob", "Manager", 80000));
        ems.addEmployee(new Employee(3, "Charlie", "Analyst", 60000));
        ems.addEmployee(new Employee(4, "Diana", "HR", 65000));
        ems.addEmployee(new Employee(5, "Eve", "Designer", 70000));

        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Search for an employee
        System.out.println("\nSearching for employee with ID 3:");
        Employee employee = ems.searchEmployeeById(3);
        System.out.println(employee != null ? employee : "Employee not found.");

        // Delete an employee
        System.out.println("\nDeleting employee with ID 2:");
        ems.deleteEmployeeById(2);
        System.out.println("All Employees after deletion:");
        ems.traverseEmployees();
    }
}
