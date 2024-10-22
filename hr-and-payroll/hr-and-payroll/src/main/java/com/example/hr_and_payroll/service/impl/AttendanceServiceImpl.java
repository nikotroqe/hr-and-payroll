package com.example.hr_and_payroll.service.impl;

import com.example.hr_and_payroll.domain.dto.AttendanceDTO;
import com.example.hr_and_payroll.domain.entity.Attendance;
import com.example.hr_and_payroll.exception.ResourceNotFoundException;
import com.example.hr_and_payroll.mapper.AttendanceMapper;
import com.example.hr_and_payroll.repository.AttendanceRepository;
import com.example.hr_and_payroll.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Override
    public AttendanceDTO createAttendance(AttendanceDTO attendanceDTO) {
        Attendance attendance = AttendanceMapper.mapToAttendance(attendanceDTO);
        Attendance savedAttendance = attendanceRepository.save(attendance);
        return AttendanceMapper.mapToAttendanceDto(savedAttendance);
    }

    @Override
    public AttendanceDTO getAttendanceById(Integer attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(()-> new ResourceNotFoundException("Attendance is not exist with given id: " + attendanceId));
        return AttendanceMapper.mapToAttendanceDto(attendance);
    }
    //getAllAttendance
    @Override
    public Page<Attendance> getAllAttendance1(Map<String, Object> filterRequest, Integer page, Integer size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return attendanceRepository.findAll(pageable);
    }

    @Override
    public AttendanceDTO updateAttendance(Integer attendanceId, AttendanceDTO updatedAttendance) {
        Attendance attendance = attendanceRepository.findById(attendanceId).orElseThrow(
                () -> new ResourceNotFoundException("Attendance is not exist with given id: " + attendanceId)
        );
        attendance.setDate(updatedAttendance.getDate());
        attendance.setCheckInTime(updatedAttendance.getCheckInTime());
        attendance.setCheckOutTime(updatedAttendance.getCheckOutTime());
        attendance.setHoursWorked(updatedAttendance.getHoursWorked());

        Attendance updatedAttendanceObj = attendanceRepository.save(attendance);

        return AttendanceMapper.mapToAttendanceDto(updatedAttendanceObj);
    }

    @Override
    public void deleteAttendance(Integer attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId).orElseThrow(
                () -> new ResourceNotFoundException("Attendance is not exist with given id: " + attendanceId)
        );
        attendanceRepository.deleteById(attendanceId);
    }

}
