package com.example.hr_and_payroll.repository;

import com.example.hr_and_payroll.domain.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer>, QuerydslPredicateExecutor<Leave> {
    /*@Query("SELECT l FROM Leave l WHERE l.employee.id = :employeeId")
    List<Leave> findLeaveByEmployee(@Param("employeeId") Integer employeeId);

    @Query("SELECT l.leaveType, COUNT(l) FROM Leave l GROUP BY l.leaveType")
    List<Object[]> findLeaveTypeStatistics();

    @Query("SELECT l FROM Leave l WHERE l.startDate BETWEEN :startDate AND :endDate")
    List<Leave> findLeaveBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);*/
}
