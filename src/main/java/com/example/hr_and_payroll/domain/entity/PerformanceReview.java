package com.example.hr_and_payroll.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "performance_reviews")
public class PerformanceReview  extends  BaseDomain {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "review_date", nullable = false)
    private LocalDate reviewDate;
    @Column(name = "comments")
    private String comments;
    @Column(name = "rating")
    private Integer rating;// Rating out of 10 or any other scale

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id",unique = true)
    private Employee employee;

    public PerformanceReview(LocalDate reviewDate, String comments, Integer rating) {
        this.reviewDate = reviewDate;
        this.comments = comments;
        this.rating = rating;
    }
}
