package com.cg.employees.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employees.entity.Employee;
import com.employees.service.EmployeeService;

@RestController
@RequestMapping("/employees")

public class EmployeeController {
	@Autowired
	EmployeeService employeeservice;
	
	@PostMapping("/addemployee")
	public String addEmployee(@RequestBody Employee Employee) {
		String str= employeeservice.addEmployee(Employee);
		return str;
	}
	
	@PutMapping("/editemployee")
	public String editEmployee(@RequestBody Employee emp) {
		return employeeservice.addEmployee(emp);
	}
	
	@DeleteMapping("/removeemployee/{empno}")
	public String removeEmployee(@PathVariable Integer empno) {
		return employeeservice.removeEmployee(empno);
	}
	
	@GetMapping("/getallempls")
	public List<Employee> display(){
		return employeeservice.getAll();
	}
	
	@GetMapping("/getempbyid")
	public Optional<Employee> getById(@RequestParam("id")int id) {
		return employeeservice.getById(id);
	}
	
	
//	@GetMapping("/getempbyName")
//	public Employee getbyName(@RequestParam("name")String name) {
//		return employeeservice.getByEmployeeName(name);
//	}
	@GetMapping("/department/{deptName}")
	public ResponseEntity<List<Employee>> getEmployeesByDeptName(@PathVariable String deptName) {
	    List<Employee> employees = employeeservice.getEmployeesByDeptName(deptName);
	    return ResponseEntity.ok(employees);
	}

	
}
