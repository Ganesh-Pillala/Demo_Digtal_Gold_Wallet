package com.cg.employees.dto;

import java.time.LocalDate;

public class EmployeeDTO {
	 private int empno;
	    private String fullName;
	    private String job;
	    private String email;
	    private int mobile;
	    private LocalDate dateJoined;
	    private String departmentName;
		public int getEmpno() {
			return empno;
		}
		public void setEmpno(int empno) {
			this.empno = empno;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getMobile() {
			return mobile;
		}
		public void setMobile(int mobile) {
			this.mobile = mobile;
		}
		public LocalDate getDateJoined() {
			return dateJoined;
		}
		public void setDateJoined(LocalDate dateJoined) {
			this.dateJoined = dateJoined;
		}
		public String getDepartmentName() {
			return departmentName;
		}
		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

}
