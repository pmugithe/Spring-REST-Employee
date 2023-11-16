package com.allsol.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.allsol.employee.dao.EmployeeDAO;
import com.allsol.employee.entities.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO empDao;

	public EmployeeServiceImpl(EmployeeDAO empDao) {
		super();
		this.empDao = empDao;
	}



	@Override
	public List<Employee> findAll() {
		List<Employee> empList = empDao.findAll();
		return empList;
	}



	@Override
	public Employee getEmpById(int id) {
		
		return empDao.getEmpById(id);
	}


	@Transactional
	@Override
	public Employee saveAnEmp(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.saveAnEmp(emp);
	}


	@Transactional
	@Override
	public void deleteEmpById(int id) {
		empDao.deleteEmpById(id);
		
	}

}
