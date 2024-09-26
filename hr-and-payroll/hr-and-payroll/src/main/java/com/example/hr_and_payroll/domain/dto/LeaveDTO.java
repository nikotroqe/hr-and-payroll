package com.example.hr_and_payroll.domain.dto;

import com.example.hr_and_payroll.domain.entity.LeaveStatus;
import com.example.hr_and_payroll.domain.entity.LeaveType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class LeaveDTO {
    private int id;
    private int employeeId;
    private LeaveType type;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private long totalDays;
    private LeaveStatus status;

    public LeaveDTO(int id, int employeeId, LocalDate startDate, LocalDate endDate, long totalDays) {
        this.id = id;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalDays = totalDays;
    }

    public LeaveDTO(int employeeId, LeaveType type, LocalDate startDate, LocalDate endDate, long totalDays, LeaveStatus status) {
        this.employeeId = employeeId;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalDays = totalDays;
        this.status = status;
    }

    public LeaveDTO(int id) {
        this.id = id;
    }
}
