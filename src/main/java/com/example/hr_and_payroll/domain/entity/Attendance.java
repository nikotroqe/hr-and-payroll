package com.example.hr_and_payroll.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.JoinColumn;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "attendance")
public class Attendance extends BaseDomain{

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id",unique = true)
    private Employee employee;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "check_in_time")
    private LocalTime checkInTime;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "check_out_time")
    private LocalTime checkOutTime;

    @Column(name = "hoursWorked")
    private double hoursWorked;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AttendanceStatus status;

    @OneToOne(fetch = FetchType.LAZY)
    private Overtime overtime;

    public Attendance(Employee employee, LocalDate date, LocalTime checkInTime, LocalTime checkOutTime, double hoursWorked, AttendanceStatus status) {
        this.employee = employee;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.hoursWorked = hoursWorked;
        this.status = status;

    }

    public Attendance(LocalDate date, LocalTime checkInTime, LocalTime checkOutTime, double hoursWorked) {
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.hoursWorked = hoursWorked;
    }

}
