package homework2_5.controller;

import homework2_5.entity.Department;
import homework2_5.entity.Employee;
import homework2_5.exception.EmployeeAlreadyAddedException;
import homework2_5.exception.EmployeeNotFoundException;
import homework2_5.exception.EmployeeStorageIsFullException;
import homework2_5.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeesController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public String handlerException(EmployeeAlreadyAddedException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handlerException(EmployeeNotFoundException e) {
        return String.format("%s %s", HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmployeeStorageIsFullException.class)
    public String handlerException(EmployeeStorageIsFullException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    private final EmployeesService employeesServiceImpl;

    @Autowired
    public EmployeesController(EmployeesService employeesServiceImpl) {
        this.employeesServiceImpl = employeesServiceImpl;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(name = "firstName") String firstName,
                                @RequestParam(name = "lastName") String lastName,
                                @RequestParam(name = "department") Department department,
                                @RequestParam(name = "salary") double salary) {
        return employeesServiceImpl.add(firstName, lastName, department, salary);
    }

    @RequestMapping("/find")
    public Employee findEmployee(@RequestParam(name = "firstName") String firstName,
                                 @RequestParam(name = "lastName") String lastName) {
        return employeesServiceImpl.find(firstName, lastName);
    }

    @RequestMapping("/remove")
    public Employee removeEmployee(@RequestParam(name = "firstName") String firstName,
                                   @RequestParam(name = "lastName") String lastName) {
        return employeesServiceImpl.remove(firstName, lastName);
    }

    @RequestMapping("/findAll")
    public Collection<Employee> getEmployees() {
        return employeesServiceImpl.getAll();
    }
}