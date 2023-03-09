package homework2_5.service;

import homework2_5.entity.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeesService {
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> getAll();
}