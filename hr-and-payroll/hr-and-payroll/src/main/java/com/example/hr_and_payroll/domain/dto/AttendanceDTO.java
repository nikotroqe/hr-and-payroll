package com.example.hr_and_payroll.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class AttendanceDTO {
    private int id;
    private int employeeId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private double hoursWorked;


    public AttendanceDTO(int id, int employeeId,LocalDate date, LocalTime checkInTime, LocalTime checkOutTime, double hoursWorked) {
        this.id = id;
        this.employeeId = employeeId;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.hoursWorked = hoursWorked;
    }
}
