package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.entity.Leave;

public interface EmailService {
    void sendSimpleMailMessage(Leave leave);
}
