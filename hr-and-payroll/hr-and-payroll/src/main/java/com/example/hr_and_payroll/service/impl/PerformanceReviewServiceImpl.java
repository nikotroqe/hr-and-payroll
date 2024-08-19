package com.example.hr_and_payroll.service.impl;

import com.example.hr_and_payroll.domain.dto.PerformanceReviewDTO;
import com.example.hr_and_payroll.domain.entity.PerformanceReview;
import com.example.hr_and_payroll.exception.ResourceNotFoundException;
import com.example.hr_and_payroll.mapper.PerformanceReviewMapper;
import com.example.hr_and_payroll.repository.PerformanceReviewRepository;
import com.example.hr_and_payroll.service.PerformanceReviewService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PerformanceReviewServiceImpl implements PerformanceReviewService {

    private final PerformanceReviewRepository performanceReviewRepository;
    @Override
    public PerformanceReviewDTO createPerformanceReview(PerformanceReviewDTO performanceReviewDTO) {
        PerformanceReview performanceReview = PerformanceReviewMapper.mapToPerformanceReview(performanceReviewDTO);
        PerformanceReview savedPerformanceReview = performanceReviewRepository.save(performanceReview);
        return PerformanceReviewMapper.mapToPerformanceReviewDto(savedPerformanceReview);
    }

    @Override
    public PerformanceReviewDTO getPerformanceReviewById(Integer performanceReviewId) {
        PerformanceReview performanceReview = performanceReviewRepository.findById(performanceReviewId)
                .orElseThrow(()-> new ResourceNotFoundException("Performance Review is not exist with given id: " + performanceReviewId));
        return PerformanceReviewMapper.mapToPerformanceReviewDto(performanceReview);
    }

    @Override
    public List<PerformanceReviewDTO> getAllPerformanceReview() {
        List<PerformanceReview> performanceReview = performanceReviewRepository.findAll();
        return performanceReview.stream().map((performanceReviews) -> PerformanceReviewMapper.mapToPerformanceReviewDto(performanceReviews))
                .collect(Collectors.toList());
    }

    @Override
    public Page<PerformanceReview> getAllPerformanceReview1(Map<String, Object> filterRequest, int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return performanceReviewRepository.findAll(pageable);
    }

    @Override
    public PerformanceReviewDTO updatePerformanceReview(Integer performanceReviewId, PerformanceReviewDTO updatedPerformanceReview) {
        PerformanceReview performanceReview = performanceReviewRepository.findById(performanceReviewId).orElseThrow(
                () -> new ResourceNotFoundException("Performance Review is not exist with given id: " + performanceReviewId)
        );
        performanceReview.setReviewDate(updatedPerformanceReview.getReviewDate());
        performanceReview.setComments(updatedPerformanceReview.getComments());
        performanceReview.setRating(updatedPerformanceReview.getRating());

        PerformanceReview updatedPerformanceReviewObj = performanceReviewRepository.save(performanceReview);

        return PerformanceReviewMapper.mapToPerformanceReviewDto(updatedPerformanceReviewObj);
    }

    @Override
    public void deletePerformanceReview(Integer performanceReviewId) {
            PerformanceReview performanceReview = performanceReviewRepository.findById(performanceReviewId).orElseThrow(
                    () -> new ResourceNotFoundException("Performance Review is not exist with given id: " + performanceReviewId)
            );
            performanceReviewRepository.deleteById(performanceReviewId);
    }

}
