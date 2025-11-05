package com.cg.employees.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employees.entity.Department;
import com.cg.employees.entity.Employee;
import com.cg.employees.exceptions.EmployeeIdAlreadyExistsException;
import com.cg.employees.exceptions.EmployeeNotFoundException;
import com.cg.employees.repository.DepartmentRepository;
import com.cg.employees.repository.EmployeeRepository;
import com.employees.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
    private EmployeeRepository employeesRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
//    @Override
//    public String addEmployee(Employee employee) {
//    	if (employeesRepository.existsById(employee.getEmpno())) {
//            throw new EmployeeIdAlreadyExistsException("Employee ID already exists: " + employee.getEmpno());
//        }
//
//        // Continue with saving logic...
//        employeesRepository.save(employee);
//        return "Employee added successfully";
//
//    }
	
//	@Override
//	public String addEmployee(Employee employee) {
//	    int empno = employee.getEmpno();
//
//	    // Check if empno already exists
//	    if (employeesRepository.existsById(empno)) {
//	        throw new EmployeeIdAlreadyExistsException("Employee ID already exists: " + empno);
//	    }
//
//	    // Fetch department using deptno
//	    int deptno = employee.getDeptno();
//	    Department dept = departmentRepository.findById(deptno)
//	        .orElseThrow(() -> new RuntimeException("Department not found with ID: " + deptno));
//
//	    // Set department object
//	    employee.setDepartment(dept);
//
//	    // Save employee
//	    employeesRepository.save(employee);
//	    return "Employee added successfully with empno: " + empno;
//	}

	@Override
	public String addEmployee(Employee employee) {
	    int empno = employee.getEmpno();
	    int deptno = employee.getDeptno();

	    // Validate empno format: must start with deptno and be ≥ deptno * 100 + 1
	    int minEmpno = deptno * 100 + 1;
	    if (empno < minEmpno || !String.valueOf(empno).startsWith(String.valueOf(deptno))) {
	        throw new RuntimeException("Invalid empno. For dept " + deptno + ", empno must start with " + deptno + " and be ≥ " + minEmpno);
	    }

	    if (employeesRepository.existsById(empno)) {
	        throw new EmployeeIdAlreadyExistsException("Employee ID already exists: " + empno);
	    }

	    Department dept = departmentRepository.findById(deptno)
	        .orElseThrow(() -> new RuntimeException("Department not found with ID: " + deptno));

	    employee.setDepartment(dept);
	    employeesRepository.save(employee);

	    return "Employee added successfully with empno: " + empno;
	}
	
    @Override
    public String removeEmployee(int empno) {
        if (!employeesRepository.existsById(empno)) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + empno);
        }
        employeesRepository.deleteById(empno);
        return "Employee removed successfully";
    }
    
    @Override
    public List<Employee> getAll() {
        return employeesRepository.findAll();
    }

    @Override
    public Optional<Employee> getById(int id) {
        return employeesRepository.findById(id);
    }

    @Override
    public Employee getByEmployeeName(String name) {
        return employeesRepository.findByFirstName(name)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with name: " + name));
    }
    
    @Override
    public List<Employee> getEmployeesByDeptName(String deptName) {
        return employeesRepository.findByDepartment_DeptName(deptName);
    }


}
