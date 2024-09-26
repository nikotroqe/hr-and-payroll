package com.example.hr_and_payroll.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OvertimeDTO {
    private Integer id;
    private Integer employeeId;
    private double overtimeHours;
    private double regularHours;
    //private Integer attendanceId;

    public OvertimeDTO(Integer id, Integer employeeId, double overtimeHours, double regularHours) {
        this.id = id;
        this.employeeId = employeeId;
        this.overtimeHours = overtimeHours;
        this.regularHours = regularHours;
        //this.attendanceId = attendanceId;
    }
}
