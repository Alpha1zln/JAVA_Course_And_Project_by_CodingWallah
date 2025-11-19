package com.example.dbops.service;

import com.example.dbops.repository.DBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    private DBRepository repository;

    public String createTable() {
        repository.createTable();
        return "Table 'employee' created successfully!";
    }

    public String insertEmployee(String name, String dept, double salary) {
        repository.insert(name, dept, salary);
        return "Employee inserted!";
    }

    public String updateEmployee(int id, String name, String dept, double salary) {
        int rows = repository.update(id, name, dept, salary);
        return rows > 0 ? "Employee updated!" : "Employee not found!";
    }

    public String deleteEmployee(int id) {
        int rows = repository.delete(id);
        return rows > 0 ? "Employee deleted!" : "Employee not found!";
    }
}
