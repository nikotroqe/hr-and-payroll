package com.example.hr_and_payroll.service.impl;

import com.example.hr_and_payroll.domain.dto.EmployeeDTO;
import com.example.hr_and_payroll.domain.dto.EmployeeQueryDsl;
import com.example.hr_and_payroll.domain.entity.Department;
import com.example.hr_and_payroll.domain.entity.Employee;
import com.example.hr_and_payroll.domain.hr.EmployeeFilter;
import com.example.hr_and_payroll.exception.ResourceNotFoundException;
import com.example.hr_and_payroll.mapper.EmployeeMapper;
import com.example.hr_and_payroll.repository.DepartmentRepository;
import com.example.hr_and_payroll.repository.EmployeeRepository;
import com.example.hr_and_payroll.service.EmployeeService;
import com.querydsl.core.types.Predicate;
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
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeQueryDsl employeeQueryDsl;


    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + employeeDTO.getDepartmentId()));

        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setAge(employeeDTO.getAge());
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setSalary(employeeDTO.getSalary());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setEndDate(employeeDTO.getEndDate());
        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public Page<EmployeeDTO> getAllEmployees1(Map<String, Object> filterRequest, int page, int size, String sort) {

        EmployeeFilter employeeFilter = new EmployeeFilter();
        if (filterRequest.containsKey("firstName")) {
            employeeFilter.setFirstName((String) filterRequest.get("firstName"));
        }
        if (filterRequest.containsKey("lastName")) {
            employeeFilter.setLastName((String) filterRequest.get("lastName"));
        }
        // Add other filters if needed

        // Create Pageable object
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        // Build the query predicate based on EmployeeFilter using EmployeeQueryDsl
        Predicate predicate = employeeQueryDsl.filter(employeeFilter);

        // Fetch the data from the repository with filtering and pagination
        Page<Employee> employees = employeeRepository.findAll(predicate, pageable);

        // Map the result to EmployeeDTO
        return employees.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId)
        );
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setAge(updatedEmployee.getAge());
        employee.setDesignation(updatedEmployee.getDesignation());
        employee.setSalary(updatedEmployee.getSalary());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId)
        );
        employeeRepository.deleteById(employeeId);
    }

}
