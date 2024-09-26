package com.example.hr_and_payroll.controller;

import com.example.hr_and_payroll.domain.dto.LeaveRequestDTO;
import com.example.hr_and_payroll.domain.entity.LeaveRequest;
import com.example.hr_and_payroll.service.LeaveRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/request")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    @PostMapping("/create")
    public ResponseEntity<LeaveRequestDTO> createLeaveRequest(@RequestBody LeaveRequestDTO leaveRequestDTO){
        LeaveRequestDTO savedLeaveRequest = leaveRequestService.createLeaveRequest(leaveRequestDTO);
        return new ResponseEntity<>(savedLeaveRequest, HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<LeaveRequestDTO> getLeaveRequestById(@PathVariable("id") int id){
        LeaveRequestDTO leaveRequestDTO = leaveRequestService.getLeaveRequestById(id);
        return ResponseEntity.ok(leaveRequestDTO);
    }

    @GetMapping("/list")
    public Page<LeaveRequest> listLeaveRequest(
            @Valid @RequestParam Map<String, Object> filterRequest,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String sort
    ) {
        return leaveRequestService.getAllLeaveRequest1(filterRequest, page, size, sort);
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<LeaveRequest> approveLeaveRequest(@PathVariable int id) {
        LeaveRequest updatedRequest = leaveRequestService.approveLeaveRequest(id);
        return ResponseEntity.ok(updatedRequest);
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<LeaveRequest> rejectLeaveRequest(@PathVariable int id) {
        LeaveRequest updatedRequest = leaveRequestService.rejectLeaveRequest(id);
        return ResponseEntity.ok(updatedRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveRequest> modifyLeaveRequest(
            @PathVariable int id,
            @RequestBody LeaveRequest updatedLeaveRequest) {
        LeaveRequest updatedRequest = leaveRequestService.modifyLeaveRequest(id, updatedLeaveRequest);
        return ResponseEntity.ok(updatedRequest);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<LeaveRequestDTO> updateLeaveRequest(@PathVariable("id") int id,
                                                @RequestBody LeaveRequestDTO updateLeaveRequest){
        LeaveRequestDTO leaveRequestDTO = leaveRequestService.updateLeaveRequest(id, updateLeaveRequest);
        return ResponseEntity.ok(leaveRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLeaveRequest(@PathVariable("id") int id){
        leaveRequestService.deleteLeaveRequest(id);
        return ResponseEntity.ok("LeaveRequest deleted successfully!.");
    }
}
