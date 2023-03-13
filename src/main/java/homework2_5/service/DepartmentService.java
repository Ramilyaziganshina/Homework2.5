package homework2_5.service;

import homework2_5.entity.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee employeeWithMaxSalary(int departmentId);

    Employee employeeWithMinSalary(int departmentId);

    Map<String, List<Employee>> getAll(Integer departmentId);

}
