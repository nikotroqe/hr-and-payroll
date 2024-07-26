package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.dto.EmployeeDTO;
import com.example.hr_and_payroll.domain.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Integer employeeId);
    List<EmployeeDTO> getAllEmployees();
    Page<EmployeeDTO> getAllEmployees1(Map<String, Object> filterRequest, int page, int size, String sort);
    EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO updatedEmployee);
    void deleteEmployee(Integer employeeId);

}


