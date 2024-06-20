package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.dto.PerformanceReviewDTO;

import java.util.List;

public interface PerformanceReviewService {
    PerformanceReviewDTO createPerformanceReview(PerformanceReviewDTO performanceReviewDTO);
    PerformanceReviewDTO getPerformanceReviewById(Integer performanceReviewId);
    List<PerformanceReviewDTO> getAllPerformanceReview();
    PerformanceReviewDTO updatePerformanceReview(Integer performanceReviewId, PerformanceReviewDTO updatedPerformanceReview);
    void deletePerformanceReview(Integer performanceReviewId);

}
