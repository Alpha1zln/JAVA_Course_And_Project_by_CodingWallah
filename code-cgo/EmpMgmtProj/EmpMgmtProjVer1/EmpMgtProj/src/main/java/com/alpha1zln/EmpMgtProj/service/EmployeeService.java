package com.alpha1zln.EmpMgtProj.service;



import com.alpha1zln.EmpMgtProj.model.Employee;
import com.alpha1zln.EmpMgtProj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public int addEmployee(Employee emp) {
        return repository.save(emp);
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getEmployee(int id) {
        return repository.findById(id);
    }

    public int updateEmployee(Employee emp) {
        return repository.update(emp);
    }

    public int deleteEmployee(int id) {
        return repository.delete(id);
    }
}
