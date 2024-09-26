package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.dto.LeaveRequestDTO;
import com.example.hr_and_payroll.domain.entity.LeaveRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface LeaveRequestService {

    LeaveRequestDTO createLeaveRequest(LeaveRequestDTO leaveRequestDTO);
    List<LeaveRequestDTO> getAllLeaveRequests();
    LeaveRequestDTO getLeaveRequestById(int id);
    LeaveRequest approveLeaveRequest(int id);
    LeaveRequest rejectLeaveRequest(int id);
    LeaveRequest modifyLeaveRequest(int id, LeaveRequest updatedLeaveRequest);
    Page<LeaveRequest> getAllLeaveRequest1(Map<String, Object> filterRequest, Integer page, Integer size, String sort);
    LeaveRequestDTO updateLeaveRequest(int id, LeaveRequestDTO updateLeaveRequest);
    void deleteLeaveRequest(int id);

}
