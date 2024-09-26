package com.example.hr_and_payroll.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "leave_request")
public class LeaveRequest extends BaseDomain{

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", unique = true)
    private Employee employee;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "status", nullable = false)
    private LeaveStatus status;

    @Column(name = "reason")
    private String reason;

    public LeaveRequest(Employee employee, LocalDate startDate, LocalDate endDate, LeaveStatus status, String reason) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.reason = reason;
    }
}
