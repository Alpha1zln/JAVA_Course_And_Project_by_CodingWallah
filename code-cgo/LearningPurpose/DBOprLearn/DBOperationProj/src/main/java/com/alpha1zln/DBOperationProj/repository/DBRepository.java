package com.example.dbops.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DBRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // CREATE TABLE
    public void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS employee (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100),
                department VARCHAR(100),
                salary DECIMAL(10,2)
            )
        """;
        jdbcTemplate.execute(sql);
    }

    // INSERT
    public int insert(String name, String department, double salary) {
        String sql = "INSERT INTO employee (name, department, salary) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, name, department, salary);
    }

    // UPDATE
    public int update(int id, String name, String department, double salary) {
        String sql = "UPDATE employee SET name=?, department=?, salary=? WHERE id=?";
        return jdbcTemplate.update(sql, name, department, salary, id);
    }

    // DELETE
    public int delete(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}
