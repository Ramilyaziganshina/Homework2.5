package homework2_5.service;

import homework2_5.entity.Employee;
import homework2_5.exception.DepartmentSearchException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeesServiceImpl employeesServiceImpl;

    public DepartmentServiceImpl(EmployeesServiceImpl employeesServiceImpl) {
        this.employeesServiceImpl = employeesServiceImpl;
    }

    @Override
    public Employee employeeWithMaxSalary(int departmentId) {
        return employeesServiceImpl.getAll().stream()
                .filter(employee -> employee.getDepartment().getId() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new DepartmentSearchException("Департамент не найден"));
    }

    @Override
    public Employee employeeWithMinSalary(int departmentId) {
        return employeesServiceImpl.getAll().stream()
                .filter(employee -> employee.getDepartment().getId() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new DepartmentSearchException("Департамент не найден"));
    }

    @Override
    public Map<String, List<Employee>> getAll(Integer departmentId) {
        return employeesServiceImpl.getAll().stream()
                .filter(employee -> departmentId != null ?
                        employee.getDepartment().getId() == departmentId
                        : true)
                .collect(Collectors.groupingBy(
                        employee -> employee.getDepartment().getName(),
                        Collectors.mapping(e -> e, Collectors.toList()))
                );

    }
}
