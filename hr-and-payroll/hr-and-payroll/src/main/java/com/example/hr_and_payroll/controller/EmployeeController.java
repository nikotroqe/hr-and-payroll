package com.example.hr_and_payroll.controller;

import com.example.hr_and_payroll.domain.dto.EmployeeDTO;
import com.example.hr_and_payroll.domain.entity.Employee;
import com.example.hr_and_payroll.domain.hr.EmployeeFilter;
import com.example.hr_and_payroll.repository.EmployeeRepository;
import com.example.hr_and_payroll.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final EmployeeRepository employeeRepository;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Integer employeeId){
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping("/get/name")
    public ResponseEntity<List<Employee>> findByNameLike(@RequestParam String firstName){
        return new ResponseEntity<List<Employee>>(employeeRepository.findByNameLike("%"+firstName+"%"), HttpStatus.OK);
    }


    @GetMapping("/list")
    public Page<Employee> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {

        return employeeService.getAllEmployees1(page, size, sort);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Integer employeeId,
                                                      @RequestBody EmployeeDTO updatedEmployee){
        EmployeeDTO employeeDTO = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }

}
