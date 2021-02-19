package com.ems.springboot.thymleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.springboot.thymleaf.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
	
	
	//add a method to sort By last name
	public List<Employee> findAllByOrderByLastNameAsc();

}
