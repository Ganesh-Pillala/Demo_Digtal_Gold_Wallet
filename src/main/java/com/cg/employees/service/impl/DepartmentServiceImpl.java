package com.cg.employees.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employees.entity.Department;
import com.cg.employees.exceptions.DepartmentAlreadyExistsException;
import com.cg.employees.repository.DepartmentRepository;
import com.employees.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public String addDepartment(Department department) {
        if (departmentRepository.existsById(department.getDeptid())) {
            throw new DepartmentAlreadyExistsException("Department already exists with ID: " + department.getDeptid());
        }
        departmentRepository.save(department);
        return "Department added successfully";
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
