package com.example.hr_and_payroll.mapper;

import com.example.hr_and_payroll.domain.dto.OvertimeDTO;
import com.example.hr_and_payroll.domain.entity.Employee;
import com.example.hr_and_payroll.domain.entity.Overtime;

public class OvertimeMapper {
    public static OvertimeDTO mapToOvertimeDto(Overtime overtime){
        return new OvertimeDTO(
                overtime.getId(),
                overtime.getEmployee().getId(),
                overtime.getOvertimeHours(),
                overtime.isApproved()
        );
    }
    public static Overtime mapToOvertime(OvertimeDTO overtimeDTO){
        return new Overtime(
                new Employee(
                overtimeDTO.getEmployeeId()),
                overtimeDTO.getOvertimeHours(),
                overtimeDTO.isApproved()
        );
    }
}
