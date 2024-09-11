package com.example.hr_and_payroll.task;

import com.example.hr_and_payroll.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduledTasks {

    /*private final PayrollService payrollService;

    @Scheduled(cron = "0 0 1 * * ?") // Daily at 1 AM
    public void updatePayroll() {
        // Fetch employees and update payroll
    }*/
}
