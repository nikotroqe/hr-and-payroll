package com.example.hr_and_payroll.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO extends BaseDomainDTO{

    private String firstName;
    private String lastName;
    private String email;
    private Long age;
    private String designation;
    private Double salary;

    public EmployeeDTO(Integer id, String firstName, String lastName, String email, Long age, String designation, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }
}
