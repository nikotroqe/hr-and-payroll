package com.example.hr_and_payroll.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PayrollService {
/*
    private final AttendanceRepository attendanceRepository;
    private final LeaveRepository leaveRepository;
    private final OvertimeRequestRepository overtimeRequestRepository;

    public double calculateTotalSalary(Integer employeeId, double hourlyRate) {
        double totalHours = calculateTotalHours(employeeId);
        double totalOvertimeHours = calculateTotalOvertimeHours(employeeId);
        double totalLeaveDeductions = calculateTotalLeaveDeductions(employeeId);

        double baseSalary = totalHours * hourlyRate;
        double overtimePay = totalOvertimeHours * hourlyRate * 1.5; // Assuming 1.5x pay rate for overtime

        return baseSalary + overtimePay - totalLeaveDeductions;
    }

    private double calculateTotalHours(Integer employeeId) {
        List<Attendance> attendances = attendanceRepository.findAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
        return attendances.stream()
                .mapToDouble(Attendance::getHoursWorked)
                .sum();
    }

    private double calculateTotalOvertimeHours(Long employeeId) {
        List<OvertimeRequest> requests = overtimeRequestRepository.findApprovedOvertimeByEmployee(employeeId);
        return requests.stream()
                .mapToDouble(OvertimeRequest::getRequestedOvertimeHours)
                .sum();
    }

    private double calculateTotalLeaveDeductions(Integer employeeId) {
        List<Leave> leaves = leaveRepository.findLeaveByEmployee(employeeId);
        return leaves.stream()
                .filter(leave -> leave.getLeaveType() == LeaveType.UNPAID_LEAVE)
                .mapToDouble(leave -> leave.getTotalDays() * dailyRate) // Assuming dailyRate is known
                .sum();
    }*/
}
