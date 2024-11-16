package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.dto.PerformanceReviewDTO;
import com.example.hr_and_payroll.domain.entity.PerformanceReview;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface PerformanceReviewService {
    PerformanceReviewDTO createPerformanceReview(PerformanceReviewDTO performanceReviewDTO);
    PerformanceReviewDTO getPerformanceReviewById(Integer performanceReviewId);
    List<PerformanceReviewDTO> getAllPerformanceReview();
    Page<PerformanceReview> getAllPerformanceReview1(Map<String, Object> filterRequest, int page, int size, String sort);
    PerformanceReviewDTO updatePerformanceReview(Integer performanceReviewId, PerformanceReviewDTO updatedPerformanceReview);
    void deletePerformanceReview(Integer performanceReviewId);


}
