package com.allsol.employee.employeemanagement;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allsol.employee.entities.Employee;
import com.allsol.employee.service.EmployeeService;

@RestController
@RequestMapping("/allsol")
public class EmployeeRestController {
	
	private EmployeeService empService;

	@Autowired
	public EmployeeRestController(EmployeeService empService) {
		super();
		this.empService = empService;
	}


	@GetMapping("/employee")
	public List<Employee> findAll(){
		
		return empService.findAll();
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmpById(@PathVariable int employeeId) {
		
		Employee emp = empService.getEmpById(employeeId);
		
		System.out.println("Emp " + emp);
		
		if ((emp == null)) {
			throw new RuntimeException("Employee could not found :( " + employeeId); 
		}
		
		return emp;
		
	}
	@PostMapping("/employee")
	public Employee saveAnEmp(@RequestBody Employee employee) {
		employee.setId(0);
		Employee dbEmpl = empService.saveAnEmp(employee);
		
		return dbEmpl;
		
	}
	
	@PutMapping("/employee")
	public Employee updateAnEmp(@RequestBody Employee employee) {
		Employee dbEmpl = empService.saveAnEmp(employee);
		
		return dbEmpl;
		
	}
	
	
	@DeleteMapping("/employee/{employeeId}")
	public String saveAnEmp(@PathVariable int employeeId) {
		
		Employee dbEmpl = empService.getEmpById(employeeId);
		
		if(dbEmpl ==null) {
			throw new RuntimeException("Employee Could not be Found :( ");
			
			
		}
		empService.deleteEmpById(employeeId);
		
		return "DELETE EMPLOYEE";
		
	}
	

}
