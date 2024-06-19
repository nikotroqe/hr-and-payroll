package com.example.hr_and_payroll.mapper;

import com.example.hr_and_payroll.domain.dto.PerformanceReviewDTO;
import com.example.hr_and_payroll.domain.entity.PerformanceReview;

public class PerformanceReviewMapper {
    public static PerformanceReview mapToPerformanceReview(PerformanceReviewDTO performanceReviewDTO){
        return new PerformanceReview(
                performanceReviewDTO.getReviewDate(),
                performanceReviewDTO.getComments(),
                performanceReviewDTO.getRating()
        );
    }
    public static PerformanceReviewDTO mapToPerformanceReviewDto(PerformanceReview performanceReview) {
        return new PerformanceReviewDTO(
                performanceReview.getReviewDate(),
                performanceReview.getComments(),
                performanceReview.getRating()
        );
    }
}
