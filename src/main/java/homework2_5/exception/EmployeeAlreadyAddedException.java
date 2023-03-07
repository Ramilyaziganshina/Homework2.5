package homework2_5.exception;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String employeeAlreadyAddedException) {
        super(employeeAlreadyAddedException);
    }
}
