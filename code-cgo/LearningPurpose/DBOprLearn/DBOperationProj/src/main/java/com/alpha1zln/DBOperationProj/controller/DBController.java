package com.example.dbops.controller;

import com.example.dbops.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/db")
public class DBController {

    @Autowired
    private DBService service;

    @PostMapping("/create-table")
    public String createTable() {
        return service.createTable();
    }

    @PostMapping("/insert")
    public String insert(
            @RequestParam String name,
            @RequestParam String dept,
            @RequestParam double salary) {
        return service.insertEmployee(name, dept, salary);
    }

    @PutMapping("/update/{id}")
    public String update(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String dept,
            @RequestParam double salary) {
        return service.updateEmployee(id, name, dept, salary);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}
