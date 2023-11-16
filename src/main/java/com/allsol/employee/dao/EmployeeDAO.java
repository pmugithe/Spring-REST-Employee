package com.allsol.employee.dao;

import java.util.List;

import com.allsol.employee.entities.Employee;

public interface EmployeeDAO{
	
	//LIST ALL EMPLOYEES
	List<Employee> findAll();
	
	Employee getEmpById(int id);
	
	Employee saveAnEmp(Employee emp);
	
	void deleteEmpById(int id);
	
	

}
