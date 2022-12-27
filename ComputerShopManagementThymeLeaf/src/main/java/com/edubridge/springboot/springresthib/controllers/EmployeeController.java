package com.edubridge.springboot.springresthib.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.springboot.springresthib.dao.EmployeeDAO;
import com.edubridge.springboot.springresthib.entity.Employee;
import com.edubridge.springboot.springresthib.errors.EmployeeError;
import com.edubridge.springboot.springresthib.errors.EmployeeNotFoundException;
import com.edubridge.springboot.springresthib.service.EmployeeService;

@Controller
@RequestMapping("/api")

public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}

	@RequestMapping(value="/employees", method=RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee emp)
	{
	employeeService.addEmployee(emp);
	return emp;
	}
	
	@RequestMapping("/getallemp")
	public String fetchAllEmployees(Model theModel)
	{
		System.out.println("Get all employees");
		List<Employee> employees=employeeService.findAll();
		theModel.addAttribute("employeeList", employees);
		return "employeeslist";
	}
	
	@RequestMapping("/showformforadd")
	public String addEmployee(Model theModel)
	{
		System.out.println("method showformforadd");
		Employee theEmployee=new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employeeaddform";
		
	}
	
	@RequestMapping(value="/saveemp", method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee emp)
	{
		System.out.println("I'm in save method with Id:  "+emp.getId());
		employeeService.addEmployee(emp);
		return "redirect:/api/getallemp";
	}
	
	@RequestMapping(value="/showformforupdate")
	public String updateEmployee(@RequestParam("employeeId") int id, Model theModel)
	{
		System.out.println("Employee Update Form for ID = " + id);
		Employee emp=employeeService.findEmployeeById(id);
		theModel.addAttribute("employee",emp);
		return "employeeaddform";
	}
	
	@RequestMapping(value="/showformfordelete")
	public String deleteEmployee(@RequestParam("employeeId") int id, Model theModel)
	{
		System.out.println("Employee delete Form for ID = " + id);
		Employee emp=employeeService.findEmployeeById(id);
		if(emp==null)
		{
		 throw new EmployeeNotFoundException("There is no Employee with the Id :"+id);
		}
		employeeService.deleteById(id);
		return "redirect:/api/getallemp";
	}
		
}
 