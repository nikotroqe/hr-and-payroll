package com.example.hr_and_payroll.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class LeaveDTO {
    private Integer employeeId;
    private String leaveType;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Integer totalDays;
    private String status;

    public LeaveDTO(LocalDate startDate, LocalDate endDate, Integer totalDays) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalDays = totalDays;
    }


}
