package com.example.hr_and_payroll.controller;

import com.example.hr_and_payroll.domain.dto.DepartmentDTO;
import com.example.hr_and_payroll.domain.entity.Department;
import com.example.hr_and_payroll.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/create-department")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO savedDepartment = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/department-get-id/{documentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") Integer departmentId){
        DepartmentDTO departmentDTO = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDTO);
    }

    @GetMapping("/list-department")
    public Page<Department> listDep(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {

        return departmentService.getAllDepartment1(page, size, sort);
    }

    @PutMapping("/update-department/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable("id") Integer departmentId,
                                                      @RequestBody DepartmentDTO updatedDepartment){
        DepartmentDTO departmentDTO = departmentService.updateDepartment(departmentId, updatedDepartment);
        return ResponseEntity.ok(departmentDTO);
    }

    @DeleteMapping("/{id}/delete-department")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Integer departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully!.");
    }

}
