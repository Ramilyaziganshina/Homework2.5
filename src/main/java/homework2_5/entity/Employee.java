package homework2_5.entity;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private Department departmentId;
    private double salary;

    public Employee(String firstName, String lastName, Department departmentId, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Department getDepartment() {
        return departmentId;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId, salary);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        Employee employee = (Employee) other;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + departmentId + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}