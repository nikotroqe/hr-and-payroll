package com.example.hr_and_payroll.service.impl;

import com.example.hr_and_payroll.domain.dto.LeaveDTO;
import com.example.hr_and_payroll.domain.entity.Leave;
import com.example.hr_and_payroll.exception.ResourceNotFoundException;
import com.example.hr_and_payroll.mapper.LeaveMapper;
import com.example.hr_and_payroll.repository.LeaveRepository;
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
    @Override
    public LeaveDTO createLeave(LeaveDTO leaveDTO) {
        //leave.calculateTotalDays();
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
        leave.setStartDate(updatedLeave.getStartDate());
        leave.setEndDate(updatedLeave.getEndDate());
        leave.setTotalDays(updatedLeave.getTotalDays());

        Leave updatedLeaveObj = leaveRepository.save(leave);

        return LeaveMapper.mapToLeaveDto(updatedLeaveObj);
    }

    @Override
    public void deleteLeave(Integer leaveId) {
        Leave leave = leaveRepository.findById(leaveId).orElseThrow(
                () -> new ResourceNotFoundException("Leave is not exist with given id: " + leaveId)
        );
        leaveRepository.deleteById(leaveId);
    }



    /*public void approveLeave(Integer leaveId) {
        Leave leave = leaveRepository.findById(leaveId).orElseThrow(() -> new RuntimeException("Leave not found"));
        leave.setStatus(LeaveStatus.APPROVED);
        leaveRepository.save(leave);
        // Send notification
    }

    public void rejectLeave(Integer leaveId) {
        Leave leave = leaveRepository.findById(leaveId).orElseThrow(() -> new RuntimeException("Leave not found"));
        leave.setStatus(LeaveStatus.REJECTED);
        leaveRepository.save(leave);
        // Send notification
    }*/
}
