package com.employees.service;

import java.util.List;

import com.cg.employees.entity.Department;

public interface DepartmentService {
	String addDepartment(Department department);
    List<Department> getAllDepartments();
}
