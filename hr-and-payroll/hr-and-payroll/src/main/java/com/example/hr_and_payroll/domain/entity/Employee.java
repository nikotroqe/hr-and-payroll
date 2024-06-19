package com.example.hr_and_payroll.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy="employee")
    private List<PerformanceReview> performanceReviews;

    public Employee(Integer id, String firstName, String lastName, String email, Long age, String designation, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }


}
