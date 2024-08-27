package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.dto.LeaveDTO;
import com.example.hr_and_payroll.domain.entity.Leave;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface LeaveService {
    LeaveDTO createLeave(LeaveDTO leaveDTO);
    LeaveDTO getLeaveById(Integer leaveId);
    Page<Leave> getAllLeave1(Map<String, Object> filterRequest, Integer page, Integer size, String sort);
    LeaveDTO updateLeave(Integer leaveId, LeaveDTO updateLeave);
    void deleteLeave(Integer leaveId);
}
