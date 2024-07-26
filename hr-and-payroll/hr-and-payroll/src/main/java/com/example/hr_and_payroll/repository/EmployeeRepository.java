package com.example.hr_and_payroll.repository;

import com.example.hr_and_payroll.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, QuerydslPredicateExecutor<Employee> {

}
