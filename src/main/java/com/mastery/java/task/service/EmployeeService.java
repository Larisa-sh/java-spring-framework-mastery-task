package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dao.EmployeeMapper;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> showAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM employee", new EmployeeMapper());
    }

    @Override
    public Employee showEmployeeById(long id) {
        return jdbcTemplate.query("SELECT * FROM employee WHERE employee_id=?", new Object[]{id}, new EmployeeMapper()).stream().findAny().orElse(null);
    }

    @Override
    public Employee saveNewEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee VALUES(?,?,?,?,?,?,?)",
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTitle().toString(),
                employee.getGender().toString(),
                employee.getDateOfBirth());
        return employee;
    }

    @Override
    public Employee updateEmployee(long employeeId, Employee updatedEmployee) {
        jdbcTemplate.update("UPDATE employee SET first_name=?, last_name=?, department_id=?, job_title=?, gender=?, date_of_birth=? WHERE employee_id=?",
                updatedEmployee.getFirstName(),
                updatedEmployee.getLastName(),
                updatedEmployee.getDepartmentId(),
                updatedEmployee.getJobTitle().toString(),
                updatedEmployee.getGender().toString(),
                updatedEmployee.getDateOfBirth(),
                employeeId);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(long employeeId) {
        jdbcTemplate.update("DELETE FROM employee WHERE employee_id=?", employeeId);
    }
}
