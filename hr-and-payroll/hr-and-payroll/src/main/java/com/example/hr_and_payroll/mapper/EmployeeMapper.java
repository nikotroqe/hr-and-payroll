package com.example.hr_and_payroll.mapper;

import com.example.hr_and_payroll.domain.dto.EmployeeDTO;
import com.example.hr_and_payroll.domain.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDto(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getAge(),
                employee.getDesignation(),
                employee.getSalary(),
                employee.getStartDate(),
                employee.getEndDate()
        );
    }
    public static Employee mapToEmployee(EmployeeDTO employeeDTO){
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getAge(),
                employeeDTO.getDesignation(),
                employeeDTO.getSalary(),
                employeeDTO.getStartDate(),
                employeeDTO.getEndDate()
        );
    }
}
