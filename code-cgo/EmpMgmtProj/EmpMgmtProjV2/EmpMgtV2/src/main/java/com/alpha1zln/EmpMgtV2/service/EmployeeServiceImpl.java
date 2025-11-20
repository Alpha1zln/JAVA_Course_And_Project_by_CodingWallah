package com.alpha1zln.EmpMgtV2.service;



import com.alpha1zln.EmpMgtV2.dto.EmployeeDto;
import com.alpha1zln.EmpMgtV2.entity.Employee;
import com.alpha1zln.EmpMgtV2.exception.ResourceNotFoundException;
import com.alpha1zln.EmpMgtV2.repository.EmpRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmpRepositoryCrud repo;

    private EmployeeDto toDto(Employee e) {
        EmployeeDto d = new EmployeeDto();
        d.setId(e.getId());
        d.setName(e.getName());
        d.setDepartment(e.getDepartment());
        d.setSalary(e.getSalary());
        return d;
    }

    private Employee toEntity(EmployeeDto d) {
        Employee e = new Employee();
        e.setName(d.getName());
        e.setDepartment(d.getDepartment());
        e.setSalary(d.getSalary());
        e.setJoinedOn(LocalDate.now());
        return e;
    }

    @Override
    public EmployeeDto create(EmployeeDto dto) {
        @SuppressWarnings("null")
        Employee saved = repo.save(toEntity(dto));
        return toDto(saved);
    }

    @Override
    public List<EmployeeDto> getAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getById(Integer id) {
        @SuppressWarnings("null")
        Employee e = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        return toDto(e);
    }

    @Override
    public EmployeeDto update(Integer id, EmployeeDto dto) {
        @SuppressWarnings("null")
        Employee e = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        e.setName(dto.getName());
        e.setDepartment(dto.getDepartment());
        e.setSalary(dto.getSalary());
        Employee updated = repo.save(e);
        return toDto(updated);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Integer id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Employee not found with id " + id);
        repo.deleteById(id);
    }
}
