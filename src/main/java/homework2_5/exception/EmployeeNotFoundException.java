package homework2_5.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String employeeNotFoundException) {
        super(employeeNotFoundException);
    }
}