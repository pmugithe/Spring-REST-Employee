package com.allsol.employee.service;

import java.util.List;

import com.allsol.employee.entities.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee getEmpById(int id);
	
	Employee saveAnEmp(Employee emp);
	
	void deleteEmpById(int id);

}
