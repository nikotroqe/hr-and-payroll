package com.example.hr_and_payroll.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDTO {
    private int id;
    private int employeeId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @JsonFormat(pattern = "hh:mm")
    private String checkInTime;
    @JsonFormat(pattern = "hh:mm")
    private String checkOutTime;
    private double hoursWorked;
    private String status;



}
