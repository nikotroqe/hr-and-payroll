package com.example.hr_and_payroll.mapper;

import com.example.hr_and_payroll.domain.dto.DepartmentDTO;
import com.example.hr_and_payroll.domain.entity.Department;

public class DepartmentMapper {
    public static DepartmentDTO mapToDepartmentDto(Department department){
        return new DepartmentDTO(
                department.getId(),
                department.getName()
        );
    }
    public static Department mapToDepartment(DepartmentDTO departmentDTO){
        return new Department(
                departmentDTO.getName()
        );
    }
}
