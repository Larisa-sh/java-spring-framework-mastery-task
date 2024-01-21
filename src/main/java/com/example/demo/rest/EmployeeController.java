package com.example.demo.rest;

import com.example.demo.dto.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.showAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getOneEmployee(@PathVariable("employeeId") long employeeId){
        return employeeService.showEmployeeById(employeeId);
    }

    @PostMapping
    public Employee saveNewEmployee(@RequestBody Employee employee){
        return employeeService.saveNewEmployee(employee);
    }

    @PutMapping("/{employeeId}")
    public Employee replaceEmployee(@PathVariable("employeeId") long employeeId, @RequestBody Employee employee){
        return employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
