package com.mastery.java.task.rest;

import com.mastery.java.task.service.EmployeeService;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeDao;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeDao = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeDao.showAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getOneEmployee(@PathVariable("employeeId") long employeeId){
        return employeeDao.showEmployeeById(employeeId);
    }

    @PostMapping
    public Employee saveNewEmployee(@RequestBody Employee employee){
        return employeeDao.saveNewEmployee(employee);
    }

    @PutMapping("/{employeeId}")
    public Employee replaceEmployee(@PathVariable("employeeId") long employeeId, @RequestBody Employee employee){
        return employeeDao.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") long employeeId){
        employeeDao.deleteEmployee(employeeId);
    }
}
