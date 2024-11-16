package com.example.hr_and_payroll.controller;

import com.example.hr_and_payroll.domain.dto.PerformanceReviewDTO;
import com.example.hr_and_payroll.domain.dto.ProjectDTO;
import com.example.hr_and_payroll.domain.entity.Project;
import com.example.hr_and_payroll.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO){
        ProjectDTO savedProject = projectService.createProject(projectDTO);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable("id") Integer projectId){
        ProjectDTO projectDTO = projectService.getProjectById(projectId);
        return ResponseEntity.ok(projectDTO);
    }

    @GetMapping("/list")
    public Page<Project> listProject(
            @Valid @RequestParam Map<String, Object> filterRequest,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String sort
    ) {
        return projectService.getAllProject1(filterRequest, page, size, sort);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable("id") Integer projectId,
                                                      @RequestBody ProjectDTO updateProject){
        ProjectDTO projectDTO = projectService.updateProject(projectId, updateProject);
        return ResponseEntity.ok(projectDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Integer projectId){
        projectService.deleteProject(projectId);
        return ResponseEntity.ok("Project deleted successfully!.");
    }
}
