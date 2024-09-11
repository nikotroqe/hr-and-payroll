package com.example.hr_and_payroll.controller;

import com.example.hr_and_payroll.domain.dto.LeaveDTO;
import com.example.hr_and_payroll.domain.entity.Leave;
import com.example.hr_and_payroll.service.LeaveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/leave")
public class LeaveController {
    private final LeaveService leaveService;

    @PostMapping("/create")
    public ResponseEntity<LeaveDTO> createLeave(@RequestBody LeaveDTO leaveDTO){
        LeaveDTO savedLeave = leaveService.createLeave(leaveDTO);
        return new ResponseEntity<>(savedLeave, HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<LeaveDTO> getLeaveById(@PathVariable("id") Integer leaveId){
        LeaveDTO leaveDTO = leaveService.getLeaveById(leaveId);
        return ResponseEntity.ok(leaveDTO);
    }

    @GetMapping("/list")
    public Page<Leave> listLeave(
            @Valid @RequestParam Map<String, Object> filterRequest,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String sort
    ) {
        return leaveService.getAllLeave1(filterRequest, page, size, sort);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LeaveDTO> updateLeave(@PathVariable("id") Integer leaveId,
                                                          @RequestBody LeaveDTO updateLeave){
        LeaveDTO leaveDTO = leaveService.updateLeave(leaveId, updateLeave);
        return ResponseEntity.ok(leaveDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLeave(@PathVariable("id") Integer leaveId){
        leaveService.deleteLeave(leaveId);
        return ResponseEntity.ok("Leave deleted successfully!.");
    }
}
