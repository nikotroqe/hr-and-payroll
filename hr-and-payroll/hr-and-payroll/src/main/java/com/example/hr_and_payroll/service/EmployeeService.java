package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.dto.EmployeeDTO;
import com.example.hr_and_payroll.domain.entity.Employee;
import com.example.hr_and_payroll.domain.hr.EmployeeFilter;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Integer employeeId);
    List<EmployeeDTO> getAllEmployees();
    Page<Employee> getAllEmployees1(int page, int size, String sort);
    EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO updatedEmployee);
    void deleteEmployee(Integer employeeId);

}


