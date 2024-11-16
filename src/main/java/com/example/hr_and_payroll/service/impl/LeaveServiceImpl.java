package com.example.hr_and_payroll.service.impl;

import com.example.hr_and_payroll.domain.dto.LeaveDTO;
import com.example.hr_and_payroll.domain.entity.AttendanceStatus;
import com.example.hr_and_payroll.domain.entity.Leave;
import com.example.hr_and_payroll.domain.entity.LeaveStatus;
import com.example.hr_and_payroll.domain.entity.LeaveType;
import com.example.hr_and_payroll.exception.ResourceNotFoundException;
import com.example.hr_and_payroll.mapper.LeaveMapper;
import com.example.hr_and_payroll.repository.LeaveRepository;
import com.example.hr_and_payroll.service.EmailService;
import com.example.hr_and_payroll.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;

    private final EmailService emailService;

    @Override
    public LeaveDTO createLeave(LeaveDTO leaveDTO) {
        Leave leave = LeaveMapper.mapToLeave(leaveDTO);
        Leave savedLeave = leaveRepository.save(leave);
        return LeaveMapper.mapToLeaveDto(savedLeave);
    }

    @Override
    public LeaveDTO getLeaveById(Integer leaveId) {
        Leave leave = leaveRepository.findById(leaveId)
                .orElseThrow(()-> new ResourceNotFoundException("Leave is not exist with given id: " + leaveId));
        return LeaveMapper.mapToLeaveDto(leave);
    }

    @Override
    public Page<Leave> getAllLeave1(Map<String, Object> filterRequest, Integer page, Integer size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return leaveRepository.findAll(pageable);
    }

    @Override
    public LeaveDTO updateLeave(Integer leaveId, LeaveDTO updatedLeave) {
        Leave leave = leaveRepository.findById(leaveId).orElseThrow(
                () -> new ResourceNotFoundException("Leave is not exist with given id: " + leaveId)
        );
        leave.setLeaveType(LeaveType.fromValue(updatedLeave.getType()));
        leave.setStartDate(updatedLeave.getStartDate());
        leave.setEndDate(updatedLeave.getEndDate());
        leave.setTotalDays(updatedLeave.getTotalDays());
        leave.setStatus(LeaveStatus.fromValue(updatedLeave.getStatus()));

        Leave updatedLeaveObj = leaveRepository.save(leave);
        emailService.sendSimpleMailMessage(leave);
        return LeaveMapper.mapToLeaveDto(updatedLeaveObj);
    }

    @Override
    public void deleteLeave(Integer leaveId) {
        Leave leave = leaveRepository.findById(leaveId).orElseThrow(
                () -> new ResourceNotFoundException("Leave is not exist with given id: " + leaveId)
        );
        leaveRepository.deleteById(leaveId);
    }


}
