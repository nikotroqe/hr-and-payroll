package com.example.hr_and_payroll.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "attendance")
public class Attendance extends BaseDomain{

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;

    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

    @Column(name = "hours_worked")
    private Double hoursWorked;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AttendanceStatus status;

    // Optional: If there's a leave entity
    @OneToOne
    @JoinColumn(name = "leave_id")
    private Leave leave;


    public Attendance(Employee employee, LocalDate date, LocalDateTime checkInTime, LocalDateTime checkOutTime, Double hoursWorked, AttendanceStatus status, Leave leave) {
        this.employee = employee;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.hoursWorked = hoursWorked;
        this.status = status;
        this.leave = leave;
    }

    public Attendance(LocalDate date, LocalDateTime checkInTime, LocalDateTime checkOutTime, Double hoursWorked) {
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.hoursWorked = hoursWorked;
    }
}
