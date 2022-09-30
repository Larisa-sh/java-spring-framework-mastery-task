package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import com.mastery.java.task.dto.JobTitle;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EmployeeDao {

    private List<Employee> employeeList = new ArrayList<>();
    private static long EMPLOYEE_ID_COUNT;

    {
        employeeList.add(new Employee(++EMPLOYEE_ID_COUNT, "Bilbo", "Baggins", Gender.MALE, 1, JobTitle.RING_KEEPER, new GregorianCalendar(2890, Calendar.SEPTEMBER , 22)));
        employeeList.add(new Employee(++EMPLOYEE_ID_COUNT,"Frodo","Baggins", Gender.MALE,2,JobTitle.RING_DESTROYER, new GregorianCalendar(2968, Calendar.SEPTEMBER , 22)));
    }

    public List<Employee> showAllEmployees(){
        return employeeList;
    }

    public Employee showByEmployeeId(long id){
        return employeeList.stream().filter(employee -> employee.getEmployeeId()==id).findAny().orElse(null);
    }

    public void save(Employee employee){
        employee.setEmployeeId(++EMPLOYEE_ID_COUNT);
        employeeList.add(employee);
    }

    public void update(long id, Employee updatedEmployee){
        Employee employee = showByEmployeeId(id);
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setGender(updatedEmployee.getGender());
        employee.setDepartmentId(updatedEmployee.getDepartmentId());
        employee.setJobTitle(updatedEmployee.getJobTitle());
        employee.setDateOfBirth(updatedEmployee.getDateOfBirth());

    }

    public void delete(long id){
        employeeList.removeIf(employee -> employee.getEmployeeId()==id);
    }

}
