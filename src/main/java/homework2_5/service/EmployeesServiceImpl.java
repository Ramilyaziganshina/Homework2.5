package homework2_5.service;

import homework2_5.entity.Employee;
import homework2_5.exception.EmployeeAlreadyAddedException;
import homework2_5.exception.EmployeeNotFoundException;
import homework2_5.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    private final int MAX_EMPLOYEES_COUNT = 2;
    private final List<Employee> employees = new ArrayList<>();

    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.size() == MAX_EMPLOYEES_COUNT) {
            throw new EmployeeStorageIsFullException("Нельзя добавить сотрудника, закончилось место");
        }
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже добавлен");
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = find(firstName, lastName);
        for (Employee e : employees) {
            if (e.equals(employee)) {
                return e;
            }
        }
        return employee;
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = null;
        for (Employee e : employees) {
            if (e != null && firstName.equals(e.getFirstName()) && lastName.equals(e.getLastName())) {
                employee = e;
            }
        }
        if (employee == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    public List<Employee> getAll() {
        return employees;
    }
}
