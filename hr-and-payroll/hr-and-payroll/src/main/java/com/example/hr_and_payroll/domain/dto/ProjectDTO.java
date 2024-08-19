package com.example.hr_and_payroll.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProjectDTO {
    private String name;
    private String description;

    public ProjectDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
