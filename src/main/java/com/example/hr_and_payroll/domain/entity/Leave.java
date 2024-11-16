package com.example.hr_and_payroll.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "leave")
public class Leave extends BaseDomain{
    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @Enumerated(EnumType.STRING)
    @Column(name = "leave_type")
    private LeaveType leaveType;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "total_days")
    private long totalDays;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private LeaveStatus status;

    public Leave(Employee employee,LeaveType leaveType, LocalDate startDate, LocalDate endDate, long totalDays, LeaveStatus status) {
        this.employee = employee;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalDays = totalDays;
        this.status = status;
    }

    public Leave(int id,Employee employee,LeaveType leaveType, LocalDate startDate, LocalDate endDate, long totalDays, LeaveStatus status) {
        this.id = id;
        this.employee = employee;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalDays = totalDays;
        this.status = status;
    }

}
