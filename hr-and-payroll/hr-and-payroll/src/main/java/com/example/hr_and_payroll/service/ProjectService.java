package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.dto.ProjectDTO;
import com.example.hr_and_payroll.domain.entity.Project;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    ProjectDTO createProject(ProjectDTO projectDTO);
    ProjectDTO getProjectById(Integer projectDTO);
    List<ProjectDTO> getAllProject();
    Page<Project> getAllProject1(Map<String, Object> filterRequest, int page, int size, String sort);
    ProjectDTO updateProject(Integer projectId, ProjectDTO updatedProject);
    void deleteProject(Integer projectId);
}
