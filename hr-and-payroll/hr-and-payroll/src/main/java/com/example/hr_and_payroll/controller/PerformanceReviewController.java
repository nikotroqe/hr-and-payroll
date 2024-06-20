package com.example.hr_and_payroll.controller;

import com.example.hr_and_payroll.domain.dto.PerformanceReviewDTO;
import com.example.hr_and_payroll.service.PerformanceReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all-performance-review")
    public ResponseEntity<List<PerformanceReviewDTO>> getAllPerformanceReview(){
        List<PerformanceReviewDTO> performanceReview = performanceReviewService.getAllPerformanceReview();
        return ResponseEntity.ok(performanceReview);
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
