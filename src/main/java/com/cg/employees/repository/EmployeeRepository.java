package com.cg.employees.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.employees.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Custom queries like findByJob, findByDepartment, etc.
	Optional<Employee> findByFirstName(String firstName);
	List<Employee> findByDepartment_DeptName(String deptName);

}