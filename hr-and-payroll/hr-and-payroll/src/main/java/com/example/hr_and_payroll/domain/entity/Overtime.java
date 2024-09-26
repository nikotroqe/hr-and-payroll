package com.example.hr_and_payroll.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "overtime")
public class Overtime extends BaseDomain{
    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id",unique = true)
    private Employee employee;

    @Column(name = "overtime_hours")
    private Double overtimeHours;

    @Column(name = "regular_hours")
    private Double regularHours;;

    //@OneToMany
    //@JoinColumn(name = "attendance_id")
    //private Attendance attendance;


    public void OvertimeDTO(double overtimeHours, double regularHours) {

        this.overtimeHours = overtimeHours;
        this.regularHours = regularHours;
        //this.attendance = attendance;
    }

    public Overtime(double overtimeHours, double regularHours) {
        this.overtimeHours = overtimeHours;
        this.regularHours = regularHours;
    }
}
