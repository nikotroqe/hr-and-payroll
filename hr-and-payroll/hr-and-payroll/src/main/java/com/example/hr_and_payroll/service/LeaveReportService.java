package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.entity.Leave;
import com.example.hr_and_payroll.repository.LeaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaveReportService {

    /*private final LeaveRepository leaveRepository;

    public List<Leave> getLeaveBalances(Integer employeeId) {
        return leaveRepository.findLeaveByEmployee(employeeId);
    }

    public Map<String, Long> getLeaveTypeStatistics() {
        List<Object[]> results = leaveRepository.findLeaveTypeStatistics();
        return results.stream()
                .collect(Collectors.toMap(
                        result -> (String) result[0],
                        result -> (Long) result[1]
                ));
    }

    public List<Leave> getLeaveUsage(LocalDate startDate, LocalDate endDate) {
        return leaveRepository.findLeaveBetweenDates(startDate, endDate);
    }*/
}
