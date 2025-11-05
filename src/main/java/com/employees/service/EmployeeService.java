package com.employees.service;

import java.util.List;
import java.util.Optional;

import com.cg.employees.entity.Employee;

public interface EmployeeService {

	String addEmployee(Employee employee);

    String removeEmployee(int empno);

    List<Employee> getAll();

    Optional<Employee> getById(int id);

    Employee getByEmployeeName(String name);
    
    List<Employee> getEmployeesByDeptName(String deptName);
	
}
