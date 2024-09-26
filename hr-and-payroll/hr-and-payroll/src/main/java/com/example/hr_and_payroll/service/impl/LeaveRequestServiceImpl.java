package com.example.hr_and_payroll.service.impl;

import com.example.hr_and_payroll.domain.dto.LeaveRequestDTO;
import com.example.hr_and_payroll.domain.entity.LeaveRequest;
import com.example.hr_and_payroll.domain.entity.LeaveStatus;
import com.example.hr_and_payroll.exception.ResourceNotFoundException;
import com.example.hr_and_payroll.mapper.LeaveRequestMapper;
import com.example.hr_and_payroll.repository.LeaveRequestRepository;
import com.example.hr_and_payroll.service.LeaveRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaveRequestServiceImpl implements LeaveRequestService {
    @Autowired
    private LeaveRequestRepository leaveRequestRepository;
    @Override
    public LeaveRequestDTO createLeaveRequest(LeaveRequestDTO leaveRequestDTO) {
        LeaveRequest leaveRequest = LeaveRequestMapper.mapToLeaveRequest(leaveRequestDTO);
        LeaveRequest savedLeaveRequest = leaveRequestRepository.save(leaveRequest);
        return LeaveRequestMapper.mapToLeaveRequestDto(savedLeaveRequest);
    }

    @Override
    public List<LeaveRequestDTO> getAllLeaveRequests() {
        List<LeaveRequest> leaveRequests = leaveRequestRepository.findAll();
        return leaveRequests.stream().map((leaveRequests1) -> LeaveRequestMapper.mapToLeaveRequestDto(leaveRequests1))
                .collect(Collectors.toList());
    }
    @Override
    public LeaveRequestDTO getLeaveRequestById(int id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Leave Request is not exist with given id: " + id));
        return LeaveRequestMapper.mapToLeaveRequestDto(leaveRequest);

    }
    @Override
    public Page<LeaveRequest> getAllLeaveRequest1(Map<String, Object> filterRequest, Integer page, Integer size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return leaveRequestRepository.findAll(pageable);
    }

    @Override
    public LeaveRequestDTO updateLeaveRequest(int id, LeaveRequestDTO updatedLeaveRequest) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Leave Request is not exist with given id: " + id)
        );
        leaveRequest.setStartDate(updatedLeaveRequest.getStartDate());
        leaveRequest.setEndDate(updatedLeaveRequest.getEndDate());
        leaveRequest.setStatus(updatedLeaveRequest.getStatus());
        leaveRequest.setReason(updatedLeaveRequest.getReason());

        LeaveRequest updatedLeaveRequestObj = leaveRequestRepository.save(leaveRequest);

        return LeaveRequestMapper.mapToLeaveRequestDto(updatedLeaveRequestObj);

    }

    @Override
    public void deleteLeaveRequest(int id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Leave is not exist with given id: " + id)
        );
        leaveRequestRepository.deleteById(id);
    }
    @Override
    public LeaveRequest approveLeaveRequest(int id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow();
        leaveRequest.setStatus(LeaveStatus.APPROVED);
        return leaveRequestRepository.save(leaveRequest);
    }
    @Override
    public LeaveRequest rejectLeaveRequest(int id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow();
        leaveRequest.setStatus(LeaveStatus.REJECTED);
        return leaveRequestRepository.save(leaveRequest);
    }
    @Override
    public LeaveRequest modifyLeaveRequest(int id, LeaveRequest updatedLeaveRequest) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow();
        leaveRequest.setStartDate(updatedLeaveRequest.getStartDate());
        leaveRequest.setEndDate(updatedLeaveRequest.getEndDate());
        //leaveRequest.setStatus(updatedLeaveRequest.getStatus()); //new add status
        leaveRequest.setReason(updatedLeaveRequest.getReason());
        return leaveRequestRepository.save(leaveRequest);
    }
}