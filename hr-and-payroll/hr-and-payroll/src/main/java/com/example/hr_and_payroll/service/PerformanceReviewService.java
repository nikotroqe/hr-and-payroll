package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.dto.PerformanceReviewDTO;
import com.example.hr_and_payroll.domain.entity.PerformanceReview;

public interface PerformanceReviewService {
    PerformanceReviewDTO createPerformanceReview(PerformanceReviewDTO performanceReviewDTO);

}
