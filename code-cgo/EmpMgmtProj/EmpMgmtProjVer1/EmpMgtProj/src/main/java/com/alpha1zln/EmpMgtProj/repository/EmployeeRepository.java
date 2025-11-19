package com.alpha1zln.EmpMgtProj.repository;



import com.alpha1zln.EmpMgtProj.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Employee> rowMapper = (rs, rowNum) ->
            new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getDouble("salary")
            );

    // CREATE
    public int save(Employee emp) {
        String sql = "INSERT INTO employee (name, department, salary) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, emp.getName(), emp.getDepartment(), emp.getSalary());
    }

    // READ ALL
    @SuppressWarnings("null")
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // READ BY ID
    @SuppressWarnings("null")
    public Employee findById(int id) {
        String sql = "SELECT * FROM employee WHERE id=?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    // UPDATE
    public int update(Employee emp) {
        String sql = "UPDATE employee SET name=?, department=?, salary=? WHERE id=?";
        return jdbcTemplate.update(sql,
                emp.getName(), emp.getDepartment(), emp.getSalary(), emp.getId()
        );
    }

    // DELETE
    public int delete(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}
