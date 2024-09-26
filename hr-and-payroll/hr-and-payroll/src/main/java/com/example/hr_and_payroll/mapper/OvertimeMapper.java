package com.example.hr_and_payroll.mapper;

import com.example.hr_and_payroll.domain.dto.OvertimeDTO;
import com.example.hr_and_payroll.domain.entity.Overtime;

public class OvertimeMapper {
    public static OvertimeDTO mapToOvertimeDto(Overtime overtime){
        return new OvertimeDTO(
                overtime.getId(),
                overtime.getEmployee().getId(),
                overtime.getOvertimeHours(),
                overtime.getRegularHours()
                //overtime.getAttendance().getId()
        );
    }
    public static Overtime mapToOvertime(OvertimeDTO overtimeDTO){
        return new Overtime(
                overtimeDTO.getOvertimeHours(),
                overtimeDTO.getRegularHours()
        );
    }
}
