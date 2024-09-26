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
    private int id;
    private String name;
    public DepartmentDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
