package com.example.hr_and_payroll.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "overtime")
public class Overtime extends BaseDomain{
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id",unique = true)
    private Employee employee;

    @Column(name = "overtime_hours", nullable = false)
    private Double overtimeHours;

    //ketu
    @OneToOne(mappedBy="overtime",cascade = CascadeType.ALL,orphanRemoval = true)
    private Attendance attendance;

    @Column(name = "overtime_approved", nullable = false)
    private boolean isApproved;


    public Overtime(int id, Employee employee, Double overtimeHours, boolean isApproved) {
        this.id = id;
        this.employee = employee;
        this.overtimeHours = overtimeHours;
        this.isApproved = isApproved;
    }

    public Overtime(Employee employee, Double overtimeHours, boolean isApproved) {
        this.employee = employee;
        this.overtimeHours = overtimeHours;
        this.isApproved = isApproved;
    }
}
