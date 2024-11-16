package com.example.hr_and_payroll.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OvertimeDTO {
    private int id;
    private int employeeId;
    private Double overtimeHours;
    private int attendanceId;
    private boolean isApproved;

}
