package com.example.hr_and_payroll.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO{
    private String name;

    public DepartmentDTO(String name) {
        this.name = name;
    }
}
