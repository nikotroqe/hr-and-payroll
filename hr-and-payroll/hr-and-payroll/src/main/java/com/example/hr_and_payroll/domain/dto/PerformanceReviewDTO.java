package com.example.hr_and_payroll.domain.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceReviewDTO extends BaseDomainDTO{

    private LocalDate reviewDate;
    private String comments;
    private Integer rating;

    //public PerformanceReviewDTO(LocalDate reviewDate, String comments, Integer rating) {
    //    this.reviewDate = reviewDate;
    //    this.comments = comments;
    //    this.rating = rating;
    //}
}
