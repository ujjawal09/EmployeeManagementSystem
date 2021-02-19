package com.luv2code.springboot.thymleafDemo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymleafDemo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	List<Employee> theEmployees;
	@PostConstruct
	private void loadData()
	{
		Employee emp1=new Employee(1,"fName1","lName1","email1@gmail.com");
		Employee emp2=new Employee(2,"fName2","lName2","email2@gmail.com");
		Employee emp3=new Employee(3,"fName3","lName3","email3@gmail.com");
		theEmployees=new ArrayList<Employee>();
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
		
	}
	 	
	
	 	
	 	
	 	@GetMapping("/list")
	public  String listEmployees(Model theModel)
	{
		theModel.addAttribute("employees",theEmployees );
		return "list-employees";
	}
  
}
