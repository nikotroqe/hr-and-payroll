package com.example.hr_and_payroll.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OvertimeDTO {
    private int id;
    private int employeeId;
    private Double overtimeHours;
    private boolean isApproved;

    public OvertimeDTO(int id, int employeeId, Double overtimeHours, boolean isApproved) {
        this.id = id;
        this.employeeId = employeeId;
        this.overtimeHours = overtimeHours;
        this.isApproved = isApproved;
    }
}
