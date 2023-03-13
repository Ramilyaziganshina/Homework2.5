package homework2_5.service;

import homework2_5.entity.Department;
import homework2_5.entity.Employee;
import homework2_5.exception.EmployeeAlreadyAddedException;
import homework2_5.exception.EmployeeNotFoundException;
import homework2_5.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static homework2_5.entity.Department.DEPARTMENT_BY_ID;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    private final int MAX_EMPLOYEES_COUNT = 10;

    private static final List<Employee> employees = new ArrayList<>();

    static {
        Employee accounting1 = new Employee("Ivan", "Ivanov", DEPARTMENT_BY_ID.get(1), 10700);
        Employee accounting2 = new Employee("Petr", "Petrov", DEPARTMENT_BY_ID.get(1), 10200);

        Employee it1 = new Employee("Sidr", "Sidorov", DEPARTMENT_BY_ID.get(2), 200);
        Employee it2 = new Employee("Oleg", "Olegov", DEPARTMENT_BY_ID.get(2), 10211);
        Employee it3 = new Employee("Alexey", "Alexeev", DEPARTMENT_BY_ID.get(2), 99999);

        Employee support1 = new Employee("Gennady", "Gennadiev", DEPARTMENT_BY_ID.get(3), 9908);
        Employee support2 = new Employee("Valery", "Valeriev", DEPARTMENT_BY_ID.get(3), 4756);
        Employee support3 = new Employee("Kostya", "Konstantinov", DEPARTMENT_BY_ID.get(3), 8234);
        Employee support4 = new Employee("Vova", "Vladimirov", DEPARTMENT_BY_ID.get(3), 92457);

        employees.add(accounting1);
        employees.add(accounting2);
        employees.add(it1);
        employees.add(it2);
        employees.add(it3);
        employees.add(support1);
        employees.add(support2);
        employees.add(support3);
        employees.add(support4);
    }

    @Override
    public Employee add(String firstName, String lastName, Department departmentId, double salary) {
        Employee newEmployee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.size() == MAX_EMPLOYEES_COUNT) {
            throw new EmployeeStorageIsFullException("Нельзя добавить сотрудника, закончилось место");
        }
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже добавлен");
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {

        Employee employee = find(firstName, lastName);
        for (Employee e : employees) {
            if (e.equals(employee)) {
                return e;
            }
        }
        return employee;
    }

    @Override
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

    @Override
    public List<Employee> getAll() {
        return employees;
    }
}