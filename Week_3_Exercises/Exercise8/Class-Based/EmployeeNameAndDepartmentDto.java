public class EmployeeNameAndDepartmentDto {
    private final String name;
    private final String departmentName;

    public EmployeeNameAndDepartmentDto(String name, String departmentName) {
        this.name = name;
        this.departmentName = departmentName;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
