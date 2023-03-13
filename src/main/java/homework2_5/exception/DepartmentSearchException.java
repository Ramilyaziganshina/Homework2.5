package homework2_5.exception;

public class DepartmentSearchException extends RuntimeException {
    public DepartmentSearchException(String departmentSearchException) {
        super(departmentSearchException);
    }
}