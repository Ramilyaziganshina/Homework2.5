package homework2_5.controller;

import homework2_5.entity.Employee;
import homework2_5.exception.DepartmentSearchException;
import homework2_5.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/departments")
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DepartmentSearchException.class)
    public String handlerException(DepartmentSearchException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @RequestMapping("/max-salary")
    public Employee employeeWithMaxSalary(@RequestParam int departmentId) {
        return departmentService.employeeWithMaxSalary(departmentId);
    }

    @RequestMapping("/min-salary")
    public Employee employeeWithMinSalary(@RequestParam int departmentId) {
        return departmentService.employeeWithMinSalary(departmentId);
    }

    @RequestMapping("/all")
    public Map<String, List<Employee>> allInTheDepartment(@RequestParam(name = "departmentId", required = false) Integer departmentId) {
        return departmentService.getAll(departmentId);
    }
}
