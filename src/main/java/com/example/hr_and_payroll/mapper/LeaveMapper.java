package com.example.hr_and_payroll.mapper;

import com.example.hr_and_payroll.domain.dto.LeaveDTO;
import com.example.hr_and_payroll.domain.entity.*;

public class LeaveMapper {
   public static LeaveDTO mapToLeaveDto(Leave leave){
        return new LeaveDTO(
                leave.getId(),
                leave.getEmployee().getId(),
                leave.getLeaveType().name(),
                leave.getStartDate(),
                leave.getEndDate(),
                leave.getTotalDays(),
                leave.getStatus().name()
        );
    }
    public static Leave mapToLeave(LeaveDTO leaveDTO){
        return new Leave(
                new Employee(leaveDTO.getEmployeeId()),
                LeaveType.fromValue(leaveDTO.getType()),
                leaveDTO.getStartDate(),
                leaveDTO.getEndDate(),
                leaveDTO.getTotalDays(),
                LeaveStatus.fromValue(leaveDTO.getStatus())
                );
    }
}
