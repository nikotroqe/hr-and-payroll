package com.example.hr_and_payroll.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AttendanceDTO {
    private Integer employeeId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private Double hoursWorked;
    private String status;
    private Integer leaveId;

    public AttendanceDTO(LocalDate date, LocalDateTime checkInTime, LocalDateTime checkOutTime, Double hoursWorked) {
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.hoursWorked = hoursWorked;
    }
}
