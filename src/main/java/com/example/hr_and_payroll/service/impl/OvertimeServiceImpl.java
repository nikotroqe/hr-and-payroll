package com.example.hr_and_payroll.service.impl;

import com.example.hr_and_payroll.domain.dto.OvertimeDTO;
import com.example.hr_and_payroll.domain.entity.Overtime;
import com.example.hr_and_payroll.exception.ResourceNotFoundException;
import com.example.hr_and_payroll.mapper.OvertimeMapper;
import com.example.hr_and_payroll.repository.OvertimeRepository;
import com.example.hr_and_payroll.service.OvertimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OvertimeServiceImpl implements OvertimeService {

    @Autowired
    private OvertimeRepository overtimeRepository;
    @Override
    public OvertimeDTO createOvertime(OvertimeDTO overtimeDTO) {
        Overtime overtime = OvertimeMapper.mapToOvertime(overtimeDTO);
        //1. Find by id employee overtime.setEmployee
        //2. Find by id attendance dto overtime.setAttendance
        Overtime savedOvertime = overtimeRepository.save(overtime);
        return OvertimeMapper.mapToOvertimeDto(savedOvertime);
    }
    @Override
    public OvertimeDTO getOvertimeById(Integer overtimeId) {
        Overtime overtime = overtimeRepository.findById(overtimeId)
                .orElseThrow(()-> new ResourceNotFoundException("Overtime is not exist with given id: " + overtimeId));
        return OvertimeMapper.mapToOvertimeDto(overtime);
    }
    @Override
    public Page<Overtime> getAllOvertime1(Map<String, Object> filterRequest, int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return overtimeRepository.findAll(pageable);
    }
    @Override
    public OvertimeDTO updateOvertime(Integer overtimeId, OvertimeDTO updatedOvertime) {
        Overtime overtime = overtimeRepository.findById(overtimeId).orElseThrow(
                () -> new ResourceNotFoundException("Overtime is not exist with given id: " + overtimeId)
        );
        overtime.setOvertimeHours(updatedOvertime.getOvertimeHours());
        overtime.setApproved(updatedOvertime.isApproved());

        Overtime updatedOvertimeObj = overtimeRepository.save(overtime);

        return OvertimeMapper.mapToOvertimeDto(updatedOvertimeObj);
    }

    @Override
    public void deleteOvertime(Integer overtimeId) {
        Overtime overtime = overtimeRepository.findById(overtimeId).orElseThrow(
                () -> new ResourceNotFoundException("Overtime is not exist with given id: " + overtimeId)
        );
        overtimeRepository.deleteById(overtimeId);
    }
}
