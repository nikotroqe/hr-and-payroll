package com.example.hr_and_payroll.repository;

import com.example.hr_and_payroll.domain.entity.Overtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OvertimeRepository extends JpaRepository<Overtime, Integer>, QuerydslPredicateExecutor<Overtime> {
    /*@Query("SELECT o FROM Overtime o WHERE o.employee.id = :employeeId AND o.status = 'APPROVED'")
    List<Overtime> findApprovedOvertimeByEmployee(@Param("employeeId") Integer employeeId);

    @Query("SELECT o FROM Overtime o WHERE o.attendance.date BETWEEN :startDate AND :endDate AND o.status = 'APPROVED'")
    List<Overtime> findApprovedOvertimeBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);*/
}
