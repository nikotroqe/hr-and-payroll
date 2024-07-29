package com.example.hr_and_payroll.service.impl;

import com.example.hr_and_payroll.domain.dto.DepartmentDTO;
import com.example.hr_and_payroll.domain.entity.Department;
import com.example.hr_and_payroll.exception.ResourceNotFoundException;
import com.example.hr_and_payroll.mapper.DepartmentMapper;
import com.example.hr_and_payroll.repository.DepartmentRepository;
import com.example.hr_and_payroll.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = DepartmentMapper.mapToDepartment(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentById(Integer departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Department is not exist with given id: " + departmentId));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        List<Department> department = departmentRepository.findAll();
        return department.stream().map((departments) -> DepartmentMapper.mapToDepartmentDto(departments))
                .collect(Collectors.toList());
    }

    @Override
    public Page<Department> getAllDepartment1(Map<String, Object> filterRequest, int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return departmentRepository.findAll(pageable);
    }

    @Override
    public DepartmentDTO updateDepartment(Integer departmentId, DepartmentDTO updatedDepartment) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exist with given id: " + departmentId)
        );
        department.setName(updatedDepartment.getName());

        Department updatedDepartmentObj = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(updatedDepartmentObj);
    }

    @Override
    public void deleteDepartment(Integer departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exist with given id: " + departmentId)
        );
        departmentRepository.deleteById(departmentId);
    }
}
