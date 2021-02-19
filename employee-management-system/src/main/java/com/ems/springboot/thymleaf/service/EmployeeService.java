package com.ems.springboot.thymleaf.service;

import java.util.List;

import com.ems.springboot.thymleaf.entity.Employee;

public interface EmployeeService {

	
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}
