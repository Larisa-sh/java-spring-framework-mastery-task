package com.mastery.java.task.rest;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeDao employeeDao;

    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping()
    public String showAllEmployees(Model model) {
        model.addAttribute("employees", employeeDao.showAllEmployees());
        return "employee/listOfEmployees";
    }

    @GetMapping("/{employeeId}")
    public String showEmployee(@PathVariable("employeeId") long employeeId, Model model) {
        model.addAttribute("employee", employeeDao.showByEmployeeId(employeeId));
        return "employee/showEmployee";
    }

    @GetMapping("/new")
    public String showFieldForNewEmployee(@ModelAttribute("employee") Employee employee){
        return "employee/new";
    }

    @PostMapping()
    public String createNewEmployee(@ModelAttribute("employee") Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/{employeeId}/edit")
    public String edit(Model model, @PathVariable("employeeId") long employeeId){
        model.addAttribute("employee", employeeDao.showByEmployeeId(employeeId));
        return "employee/edit";
    }

    @PatchMapping("/{employeeId}")
    public String update(@ModelAttribute("person") Employee employee, @PathVariable("employeeId") long employeeId){
        employeeDao.update(employeeId, employee);
        return "redirect:/employee";
    }

    @DeleteMapping("/{employeeId}")
    public String delete(@PathVariable("employeeId") long employeeId){
        employeeDao.delete(employeeId);
        return "redirect:/employee";
    }
}
