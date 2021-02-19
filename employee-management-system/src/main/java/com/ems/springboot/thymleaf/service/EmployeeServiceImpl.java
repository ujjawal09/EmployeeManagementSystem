package com.ems.springboot.thymleaf.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.springboot.thymleaf.dao.EmployeeRepository;
import com.ems.springboot.thymleaf.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository theEmployeeRepository;
	
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return theEmployeeRepository.findAllByOrderByLastNameAsc(); 
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		
		Optional<Employee> result = theEmployeeRepository.findById(theId);
		Employee theEmployee=null;
		if(result.isPresent())
			theEmployee=result.get();
		
			
		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		theEmployeeRepository.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		theEmployeeRepository.deleteById(theId);

	}

}
