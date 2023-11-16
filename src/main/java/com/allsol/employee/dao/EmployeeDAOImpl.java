package com.allsol.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allsol.employee.entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	//Define a field for Entity Manager and Inject the constructor
	private EntityManager entityManager;
	
	public EmployeeDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	//Method to list all employees
	@Override
	public List<Employee> findAll() {
		//Create, execute and get the Results
		
		TypedQuery<Employee> empQuery = entityManager.createQuery("from Employee", Employee.class);
		
		List<Employee> employees =empQuery.getResultList();
		
		return employees;
	}
	@Override
	public Employee getEmpById(int id) {
		//Get an Employee by Id
		Employee emp = entityManager.find(Employee.class, id);
		return emp;
	}
	@Override
	public Employee saveAnEmp(Employee emp) {
		//Save an Employee
		Employee dbEmp =entityManager.merge(emp);
		return dbEmp;
	}
	@Override
	public void deleteEmpById(int id) {
		//Delete an Employee by Id
		Employee delEmp =entityManager.find(Employee.class, id);
		
		entityManager.remove(delEmp);
		
	}

}
