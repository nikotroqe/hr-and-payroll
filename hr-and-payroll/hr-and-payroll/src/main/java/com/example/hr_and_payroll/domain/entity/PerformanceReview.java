package com.example.hr_and_payroll.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "performance_reviews")
public class PerformanceReview  extends  BaseDomain {




    @Column(name = "review_date", nullable = false)
    private LocalDate reviewDate;
    @Column(name = "comments")
    private String comments;
    @Column(name = "rating")
    private Integer rating;// Rating out of 10 or any other scale

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;



}
