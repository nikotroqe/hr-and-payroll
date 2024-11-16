package com.example.hr_and_payroll.service.impl;

import com.example.hr_and_payroll.domain.entity.Leave;
import com.example.hr_and_payroll.domain.entity.LeaveStatus;
import com.example.hr_and_payroll.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    @Override
    public void sendSimpleMailMessage(Leave leave) {
        try {
            SimpleMailMessage email = new SimpleMailMessage();

            if (leave.getStatus().equals(LeaveStatus.APPROVED)) {
                System.err.println("Request approved for leave.");
            } else if (leave.getStatus().equals(LeaveStatus.REJECTED)) {
                System.err.println("Request rejected for leave.");
            }
            email.setTo(leave.getEmployee().getEmail());
            email.setSubject("Kerkesa Leje");
            email.setText("Hello " + leave.getEmployee().getFirstName() + " ! \n Your leave request of type " + leave.getLeaveType() + " from date "+leave.getStartDate()+" to "+leave.getEndDate()+" is "+ leave.getStatus());
            emailSender.send(email);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}

// https://nilhcem.com/FakeSMTP/download.html
// vjen nga application properties qe Listening port qe eshte nr. 25
//1. Te ndezim FakeEmail
//2. Te startojme Start Server
//3. Dhe testojme e checkojme ne Mail List dhe kontrollojme ne Last Message
