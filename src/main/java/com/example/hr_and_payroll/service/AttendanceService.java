package com.example.hr_and_payroll.service;

import com.example.hr_and_payroll.domain.dto.AttendanceDTO;
import com.example.hr_and_payroll.domain.entity.Attendance;
import org.springframework.data.domain.Page;
import org.springframework.data.util.Pair;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AttendanceService {
    AttendanceDTO createAttendance(AttendanceDTO attendanceDTO);
    AttendanceDTO getAttendanceById(Integer attendanceId);
    Page<Attendance> getAllAttendance1(Map<String, Object> filterRequest, Integer page, Integer size, String sort);
    AttendanceDTO updateAttendance(Integer attendanceId, AttendanceDTO updateAttendance);
    void deleteAttendance(Integer attendanceId);

    List<Pair<String,Double>> generatePayslip(LocalDate startDate, LocalDate endDate);
}
