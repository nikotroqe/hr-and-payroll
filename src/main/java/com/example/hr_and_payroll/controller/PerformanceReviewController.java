package com.example.hr_and_payroll.controller;

import com.example.hr_and_payroll.domain.dto.PerformanceReviewDTO;
import com.example.hr_and_payroll.domain.entity.Department;
import com.example.hr_and_payroll.domain.entity.PerformanceReview;
import com.example.hr_and_payroll.service.PerformanceReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/performance-review")
public class PerformanceReviewController {

    private final PerformanceReviewService performanceReviewService;

    @PostMapping("/create")
    public ResponseEntity<PerformanceReviewDTO> createPerformanceReview(@RequestBody PerformanceReviewDTO performanceReviewDTO){
        PerformanceReviewDTO savedPerformanceReview = performanceReviewService.createPerformanceReview(performanceReviewDTO);
        return new ResponseEntity<>(savedPerformanceReview, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PerformanceReviewDTO> getPerformanceReviewById(@PathVariable("id") Integer performanceReviewId){
        PerformanceReviewDTO performanceReviewDTO = performanceReviewService.getPerformanceReviewById(performanceReviewId);
        return ResponseEntity.ok(performanceReviewDTO);
    }


    @GetMapping("/list")
    public Page<PerformanceReview> listPerformanceReview(
            @Valid @RequestParam Map<String, Object> filterRequest,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {

        return performanceReviewService.getAllPerformanceReview1(filterRequest,page, size, sort);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PerformanceReviewDTO> updatePerformanceReview(@PathVariable("id") Integer performanceReviewId,
                                                      @RequestBody PerformanceReviewDTO updatedPerformanceReview){
        PerformanceReviewDTO performanceReviewDTO = performanceReviewService.updatePerformanceReview(performanceReviewId, updatedPerformanceReview);
        return ResponseEntity.ok(performanceReviewDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerformanceReview(@PathVariable("id") Integer performanceReviewId){
        performanceReviewService.deletePerformanceReview(performanceReviewId);
        return ResponseEntity.ok("Performance Review deleted successfully!.");
    }

}
