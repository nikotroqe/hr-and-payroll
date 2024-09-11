package com.example.hr_and_payroll.mapper;

import com.example.hr_and_payroll.domain.dto.LeaveDTO;
import com.example.hr_and_payroll.domain.entity.Leave;

public class LeaveMapper {
   public static LeaveDTO mapToLeaveDto(Leave leave){
        return new LeaveDTO(
                leave.getId(),
                leave.getEmployee().getId(),
                leave.getLeaveType(),
                leave.getStartDate(),
                leave.getEndDate(),
                leave.getTotalDays(),
                leave.getStatus()
        );
    }
    public static Leave mapToLeave(LeaveDTO leaveDTO){
        return new Leave(
                leaveDTO.getLeaveType(),
                leaveDTO.getStartDate(),
                leaveDTO.getEndDate(),
                leaveDTO.getTotalDays(),
                leaveDTO.getStatus()
        );
    }
}
