package com.example.hr_and_payroll.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "overtime_request")
public class Overtime extends BaseDomain{
    /*@ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id",unique = true)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "attendance_id")
    private Attendance attendance;

    @Column(name = "requested_overtime_hours")
    private Double requestedOvertimeHours;

    //@Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private String status;

    public void OvertimeDTO(Attendance attendance, Double requestedOvertimeHours, String status) {
        this.attendance = attendance;
        this.requestedOvertimeHours = requestedOvertimeHours;
        this.status = status;
    }

    public Overtime(Double requestedOvertimeHours, String status) {
        this.requestedOvertimeHours = requestedOvertimeHours;
        this.status = status;
    }*/
}
