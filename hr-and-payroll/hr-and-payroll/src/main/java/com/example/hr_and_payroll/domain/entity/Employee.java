package com.example.hr_and_payroll.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee extends  BaseDomain {


    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "age")
    private Long age;
    @Column(name = "designation")
    private String designation;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @Column(name = "end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Transient
    private Duration duration;

    @OneToMany(orphanRemoval = true, mappedBy="employee")
    private List<PerformanceReview> performanceReviews;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "id",unique = true)
    private Department department;

    public Employee(Integer id, String firstName, String lastName, String email, Long age, String designation, Double salary,LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
