package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.dto.OvertimeDTO;
import com.example.hr_and_payroll.domain.entity.Overtime;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface OvertimeService {
    OvertimeDTO createOvertime(OvertimeDTO overtimeDTO);
    OvertimeDTO getOvertimeById(Integer overtimeId);
    Page<Overtime> getAllOvertime1(Map<String, Object> filterRequest, Integer page, Integer size, String sort);
    OvertimeDTO updateOvertime(Integer overtimeId, OvertimeDTO updateOvertime);
    void deleteOvertime(Integer overtimeId);
}
