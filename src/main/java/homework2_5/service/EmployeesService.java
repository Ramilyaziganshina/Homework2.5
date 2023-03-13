package homework2_5.service;

import homework2_5.entity.Department;
import homework2_5.entity.Employee;

import java.util.Collection;

public interface EmployeesService {
    Employee add(String firstName, String lastName, Department department, double salary);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> getAll();
}