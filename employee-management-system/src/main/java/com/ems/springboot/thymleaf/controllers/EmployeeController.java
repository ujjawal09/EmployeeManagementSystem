package com.ems.springboot.thymleaf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ems.springboot.thymleaf.entity.Employee;
import com.ems.springboot.thymleaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService theEmployeeService;
	
	 	
	 	
	 	@GetMapping("/list")
	public  String listEmployees(Model theModel)
	{
	 		List<Employee> theEmployees=theEmployeeService.findAll();
		theModel.addAttribute("employees",theEmployees );
		return "Employees/list-employees";
	}
  
	 	
	 	@GetMapping("/showFormForAdd")
	 	public String showFormForAdd(Model theModel)
	 	{
	 		Employee theEmployee= new Employee();
	 		theModel.addAttribute("employee",theEmployee);
	 		return "Employees/employee-form";
	 	}
	 	
	 	@PostMapping("/save")
	 	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
	 	{
	 		theEmployeeService.save(theEmployee);
	 		return "redirect:/employees/list";
	 	}
        @GetMapping("/showFormForUpdate")
        public String  showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel)
        {
        	Employee theEmployee=theEmployeeService.findById(theId);
        	theModel.addAttribute("employee",theEmployee);
        	return "Employees/employee-form";
        }
        
        
        @GetMapping("/delete")
        public String delete(@RequestParam("employeeId") int theId, Model theModel)
        {
        	theEmployeeService.deleteById(theId);	
        	return "redirect:/employees/list";
        }

}
