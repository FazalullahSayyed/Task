package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomResponse;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> saveEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByFirstName(name);
    }

    public CustomResponse deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        String result = "Employee removed " + id;
        return new CustomResponse(result);
    }
  
    public Employee updateEmployee(int id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setJoiningDate(employee.getJoiningDate());
        existingEmployee.setStatus(employee.getStatus());
        return employeeRepository.save(existingEmployee);
    }
}
