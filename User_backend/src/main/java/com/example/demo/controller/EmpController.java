package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustomResponse;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
@RestController
@CrossOrigin
public class EmpController {
	
	
	    @Autowired
	    private EmployeeService employeeService;

	    @PostMapping("/add")
	    public Employee addEmployee(@RequestBody Employee employee) {
	        return employeeService.saveEmployee(employee);
	    }

	    @PostMapping("/add/multiple")
	    public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
	        return employeeService.saveEmployees(employees);
	    }

	    @GetMapping("/all")
	    public List<Employee> findAllEmployees() {
	        return employeeService.getEmployees();
	    }

	    @GetMapping("/{id}")
	    public Employee findEmployeeById(@PathVariable int id) {
	        return employeeService.getEmployeeById(id);
	    }

	    @GetMapping("/name/{name}")
	    public Employee findEmployeesByName(@PathVariable String name) {
	        return employeeService.getEmployeeByName(name);
	    }

	    @PutMapping("/update/{id}")
	    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
	        return employeeService.updateEmployee(id,employee);
	    }

	    @DeleteMapping("/delete/{id}")
	    public CustomResponse deleteEmployee(@PathVariable int id) {
	        return employeeService.deleteEmployee(id);
	    }

	}

