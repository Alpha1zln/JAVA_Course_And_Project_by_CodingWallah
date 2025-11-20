package com.alpha1zln.EmpMgtV2.dto;

// package com.alpha1zln.empmgt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EmployeeDto {

    private Integer id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "department is required")
    private String department;

    @NotNull(message = "salary is required")
    @Positive(message = "salary must be positive")
    private Double salary;

    public EmployeeDto() {}

    // getters & setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
