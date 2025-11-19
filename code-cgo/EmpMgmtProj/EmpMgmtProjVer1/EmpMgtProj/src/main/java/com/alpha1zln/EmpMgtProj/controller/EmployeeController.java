package com.alpha1zln.EmpMgtProj.controller;



import com.alpha1zln.EmpMgtProj.model.Employee;
import com.alpha1zln.EmpMgtProj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public String add(@RequestBody Employee emp) {
        service.addEmployee(emp);
        return "Employee added!";
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable int id) {
        return service.getEmployee(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Employee emp) {
        emp.setId(id);
        service.updateEmployee(emp);
        return "Employee updated!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Employee deleted!";
    }
}
