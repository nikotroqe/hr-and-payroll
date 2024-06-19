package com.example.hr_and_payroll.controller;

import com.example.hr_and_payroll.domain.dto.PerformanceReviewDTO;
import com.example.hr_and_payroll.domain.entity.PerformanceReview;
import com.example.hr_and_payroll.service.PerformanceReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/performance_review")
public class PerformanceReviewController {
    @Autowired
    private PerformanceReviewService performanceReviewService;

    @PostMapping
    public ResponseEntity<PerformanceReviewDTO> createPerformanceReview(@RequestBody PerformanceReviewDTO performanceReviewDTO){
        PerformanceReviewDTO savedPerformanceReview = performanceReviewService.createPerformanceReview(performanceReviewDTO);
        return new ResponseEntity<>(savedPerformanceReview, HttpStatus.CREATED);
    }

}
