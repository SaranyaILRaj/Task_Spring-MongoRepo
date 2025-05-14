package com.task.employeeapp.service;

import com.task.employeeapp.model.Employee;
import com.task.employeeapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
        //return "Employee details saved successfully";
    }

    public List<Employee> displayAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> displayEmployeeById(String id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        return emp;
    }

}
