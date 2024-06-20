package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO getDepartmentById(Integer departmentId);
    List<DepartmentDTO> getAllDepartment();
    DepartmentDTO updateDepartment(Integer departmentId, DepartmentDTO updatedDepartment);
    void deleteDepartment(Integer departmentId);
}
