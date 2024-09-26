package com.example.hr_and_payroll.mapper;

import com.example.hr_and_payroll.domain.dto.LeaveRequestDTO;
import com.example.hr_and_payroll.domain.entity.Employee;
import com.example.hr_and_payroll.domain.entity.LeaveRequest;

public class LeaveRequestMapper {
   public static LeaveRequestDTO mapToLeaveRequestDto(LeaveRequest leaveRequest){
        return new LeaveRequestDTO(
                leaveRequest.getId(),
                leaveRequest.getEmployee().getId(),
                leaveRequest.getStartDate(),
                leaveRequest.getEndDate(),
                leaveRequest.getStatus(),
                leaveRequest.getReason()
        );
    }
    public static LeaveRequest mapToLeaveRequest(LeaveRequestDTO leaveRequestDTO){
        return new LeaveRequest(
                new Employee(leaveRequestDTO.getEmployeeId()),
                leaveRequestDTO.getStartDate(),
                leaveRequestDTO.getEndDate(),
                leaveRequestDTO.getStatus(),
                leaveRequestDTO.getReason()
                );
    }
}
