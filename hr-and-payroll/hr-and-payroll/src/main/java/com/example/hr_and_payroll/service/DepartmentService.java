package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.dto.DepartmentDTO;
import com.example.hr_and_payroll.domain.entity.Department;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO getDepartmentById(Integer departmentId);
    List<DepartmentDTO> getAllDepartment();
    Page<Department> getAllDepartment1(Map<String, Object> filterRequest, int page, int size, String sort);
    DepartmentDTO updateDepartment(Integer departmentId, DepartmentDTO updatedDepartment);
    void deleteDepartment(Integer departmentId);
}
