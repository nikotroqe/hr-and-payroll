package com.example.hr_and_payroll.mapper;

import com.example.hr_and_payroll.domain.dto.OvertimeDTO;
import com.example.hr_and_payroll.domain.entity.Employee;
import com.example.hr_and_payroll.domain.entity.Overtime;
import org.springframework.stereotype.Component;

public class OvertimeMapper {
    public static OvertimeDTO mapToOvertimeDto(Overtime overtime){
        return new OvertimeDTO(
                overtime.getId(),
                overtime.getEmployee().getId(),
                overtime.getOvertimeHours(),
                overtime.getAttendance().getId(),
                overtime.isApproved()
        );
    }
    public static Overtime mapToOvertime(OvertimeDTO overtimeDTO){
        Overtime overtime = new Overtime();
        overtime.setOvertimeHours(overtime.getOvertimeHours());
        overtime.setApproved(overtimeDTO.isApproved());
        return overtime;
    }
}
