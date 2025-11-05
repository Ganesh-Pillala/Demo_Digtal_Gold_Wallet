package com.cg.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.employees.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    // Custom queries like findByLocation, findByDeptName, etc.
}