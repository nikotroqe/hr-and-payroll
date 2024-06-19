package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Integer employeeId);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO updatedEmployee);
    void deleteEmployee(Integer employeeId);
}


