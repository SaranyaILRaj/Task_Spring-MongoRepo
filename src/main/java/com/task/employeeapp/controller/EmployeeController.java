package com.task.employeeapp.controller;

import com.task.employeeapp.model.Employee;
import com.task.employeeapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/page")
    public String indexPage(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/displayAll";
    }

    @GetMapping("/displayAll")
    @ResponseBody
    public List<Employee> displayAllEmployees() {
        return employeeService.displayAllEmployees();
    }

    @GetMapping("/display/{id}")
    @ResponseBody
    public Object displayEmployeeById(@PathVariable String id) {
        Optional<Employee> emp = employeeService.displayEmployeeById(id);
        return emp.isPresent() ? emp.get() : "Employee not found";
    }
}
