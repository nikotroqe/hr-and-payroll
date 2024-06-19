package com.example.hr_and_payroll.service.impl;

import com.example.hr_and_payroll.domain.dto.PerformanceReviewDTO;
import com.example.hr_and_payroll.domain.entity.PerformanceReview;
import com.example.hr_and_payroll.mapper.PerformanceReviewMapper;
import com.example.hr_and_payroll.repository.PerformanceReviewRepository;
import com.example.hr_and_payroll.service.PerformanceReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PerformanceReviewServiceImpl implements PerformanceReviewService {

    private PerformanceReviewRepository performanceReviewRepository;
    @Override
    public PerformanceReviewDTO createPerformanceReview(PerformanceReviewDTO performanceReviewDTO) {
        PerformanceReview performanceReview = PerformanceReviewMapper.mapToPerformanceReview(performanceReviewDTO);
        PerformanceReview savedPerformanceReview = performanceReviewRepository.save(performanceReview);
        return PerformanceReviewMapper.mapToPerformanceReviewDto(savedPerformanceReview);
    }
}
