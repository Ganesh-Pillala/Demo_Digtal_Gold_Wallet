package com.cg.employees.exceptions;

public class DepartmentAlreadyExistsException extends RuntimeException{
	public DepartmentAlreadyExistsException(String message) {
        super(message);
    }

}
