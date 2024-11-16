package com.example.hr_and_payroll.mapper;

import com.example.hr_and_payroll.domain.dto.EmployeeDTO;
import com.example.hr_and_payroll.domain.entity.Department;
import com.example.hr_and_payroll.domain.entity.Employee;
import com.example.hr_and_payroll.exception.ResourceNotFoundException;
import com.example.hr_and_payroll.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    private static DepartmentRepository departmentRepository;

    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        EmployeeMapper.departmentRepository = departmentRepository;
    }
    public static EmployeeDTO mapToEmployeeDto(Employee employee){

        Integer departmentId = null;
        if (employee.getDepartment() != null) {
            departmentId = employee.getDepartment().getId();
        }
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getAge(),
                employee.getDesignation(),
                employee.getSalary(),
                employee.getStartDate(),
                employee.getEndDate(),
               departmentId
        );
    }
    public static Employee mapToEmployee(EmployeeDTO employeeDTO){

        Department department = null;
        if (employeeDTO.getDepartmentId() != null) {
            department = departmentRepository.findById(employeeDTO.getDepartmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + employeeDTO.getDepartmentId()));
        }
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getAge(),
                employeeDTO.getDesignation(),
                employeeDTO.getSalary(),
                employeeDTO.getStartDate(),
                employeeDTO.getEndDate(),
                department
        );
    }
}
