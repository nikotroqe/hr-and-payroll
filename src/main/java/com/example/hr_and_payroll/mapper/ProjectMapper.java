package com.example.hr_and_payroll.mapper;

import com.example.hr_and_payroll.domain.dto.ProjectDTO;
import com.example.hr_and_payroll.domain.entity.Project;

public class ProjectMapper {
    public static Project mapToProject(ProjectDTO projectDTO){
        return new Project(
                projectDTO.getName(),
                projectDTO.getDescription()
        );
    }

    public static ProjectDTO mapToProjectDto(Project project) {
        return new ProjectDTO(
                project.getName(),
                project.getDescription()
        );
    }
}
