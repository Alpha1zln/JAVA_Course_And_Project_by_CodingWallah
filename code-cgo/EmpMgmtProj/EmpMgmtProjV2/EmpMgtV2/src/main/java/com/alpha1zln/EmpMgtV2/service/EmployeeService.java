package com.alpha1zln.EmpMgtV2.service;



import  com.alpha1zln.EmpMgtV2.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto create(EmployeeDto dto);
    List<EmployeeDto> getAll();
    EmployeeDto getById(Integer id);
    EmployeeDto update(Integer id, EmployeeDto dto);
    void delete(Integer id);
}
