package com.example.hr_and_payroll.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class PerformanceReviewDTO{

    private LocalDate reviewDate;
    private String comments;
    private Integer rating;
    private Integer employeeId;

    public PerformanceReviewDTO(LocalDate reviewDate, String comments, Integer rating) {
        this.reviewDate = reviewDate;
        this.comments = comments;
        this.rating = rating;
    }
}
