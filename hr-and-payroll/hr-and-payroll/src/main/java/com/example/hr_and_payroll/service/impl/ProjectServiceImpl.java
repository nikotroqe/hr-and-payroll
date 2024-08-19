package com.example.hr_and_payroll.service.impl;

import com.example.hr_and_payroll.domain.dto.ProjectDTO;
import com.example.hr_and_payroll.domain.entity.PerformanceReview;
import com.example.hr_and_payroll.domain.entity.Project;
import com.example.hr_and_payroll.exception.ResourceNotFoundException;
import com.example.hr_and_payroll.mapper.PerformanceReviewMapper;
import com.example.hr_and_payroll.mapper.ProjectMapper;
import com.example.hr_and_payroll.repository.ProjectRepository;
import com.example.hr_and_payroll.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.hr_and_payroll.domain.entity.QProject.project;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = ProjectMapper.mapToProject(projectDTO);
        Project savedProject = projectRepository.save(project);
        return ProjectMapper.mapToProjectDto(savedProject);
    }

    @Override
    public ProjectDTO getProjectById(Integer projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(()-> new ResourceNotFoundException("Project is not exist with given id: " + projectId));
        return ProjectMapper.mapToProjectDto(project);
    }


    @Override
    public List<ProjectDTO> getAllProject() {
        List<Project> project = projectRepository.findAll();
        return project.stream().map((projects) -> ProjectMapper.mapToProjectDto(projects))
                .collect(Collectors.toList());
    }

    @Override
    public Page<Project> getAllProject1(Map<String, Object> filterRequest, int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return projectRepository.findAll(pageable);
    }

    @Override
    public ProjectDTO updateProject(Integer projectId, ProjectDTO updatedProject) {
        Project project = projectRepository.findById(projectId).orElseThrow(
                () -> new ResourceNotFoundException("Project is not exist with given id: " + projectId)
        );
        project.setName(updatedProject.getName());
        project.setDescription(updatedProject.getDescription());

        Project updatedProjectObj = projectRepository.save(project);

        return ProjectMapper.mapToProjectDto(updatedProjectObj);
    }

    @Override
    public void deleteProject(Integer projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(
                () -> new ResourceNotFoundException("Project is not exist with given id: " + projectId)
        );
        projectRepository.deleteById(projectId);
    }
}
