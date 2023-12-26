package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> showAllEmployees();

    public Employee showEmployeeById(long id);

    public Employee saveNewEmployee(Employee employee);

    public Employee updateEmployee(long employeeId, Employee updatedEmployee);

    public void deleteEmployee(long employeeId);
}
