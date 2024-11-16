package com.example.hr_and_payroll.repository;

import com.example.hr_and_payroll.domain.entity.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview,Integer>, QuerydslPredicateExecutor<PerformanceReview> {
}
