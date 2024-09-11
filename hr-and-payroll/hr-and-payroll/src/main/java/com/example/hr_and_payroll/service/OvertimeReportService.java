package com.example.hr_and_payroll.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OvertimeReportService {

    /*private final OvertimeRequestRepository overtimeRequestRepository;

    public List<OvertimeRequest> getApprovedOvertimeForEmployee(Integer employeeId) {
        return overtimeRequestRepository.findApprovedOvertimeByEmployee(employeeId);
    }

    public List<OvertimeRequest> getApprovedOvertimeForPeriod(LocalDate startDate, LocalDate endDate) {
        return overtimeRequestRepository.findApprovedOvertimeBetweenDates(startDate, endDate);
    }

    public double calculateTotalOvertimePay(Integer employeeId, double hourlyRate) {
        List<OvertimeRequest> requests = getApprovedOvertimeForEmployee(employeeId);
        double totalHours = requests.stream()
                .mapToDouble(OvertimeRequest::getRequestedOvertimeHours)
                .sum();
        return totalHours * hourlyRate;
    }*/
}
