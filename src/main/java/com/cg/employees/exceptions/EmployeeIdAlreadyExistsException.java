package com.cg.employees.exceptions;


public class EmployeeIdAlreadyExistsException extends RuntimeException {

    public EmployeeIdAlreadyExistsException(String message) {
        super(message);
    }
}
