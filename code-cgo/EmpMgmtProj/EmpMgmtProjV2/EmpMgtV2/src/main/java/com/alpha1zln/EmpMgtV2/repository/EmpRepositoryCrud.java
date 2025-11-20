package com.alpha1zln.EmpMgtV2.repository;


import com.alpha1zln.EmpMgtV2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepositoryCrud extends JpaRepository<Employee, Integer> {
    // custom queries (if needed) can go here
}
