package com.example.hr_and_payroll.service.impl;

import com.example.hr_and_payroll.domain.dto.AttendanceDTO;
import com.example.hr_and_payroll.domain.entity.Attendance;
import com.example.hr_and_payroll.domain.entity.AttendanceStatus;
import com.example.hr_and_payroll.domain.entity.Employee;
import com.example.hr_and_payroll.domain.entity.Overtime;
import com.example.hr_and_payroll.exception.ResourceNotFoundException;
import com.example.hr_and_payroll.mapper.AttendanceMapper;
import com.example.hr_and_payroll.repository.AttendanceRepository;
import com.example.hr_and_payroll.repository.OvertimeRepository;
import com.example.hr_and_payroll.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final OvertimeRepository overtimeRepository;
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
        attendance.setCheckInTime(LocalTime.parse(updatedAttendance.getCheckInTime() ));
        attendance.setCheckOutTime(LocalTime.parse(updatedAttendance.getCheckOutTime()));
        attendance.setHoursWorked(updatedAttendance.getHoursWorked());
        attendance.setStatus(AttendanceStatus.fromValue(updatedAttendance.getStatus()));
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

    @Override
    public List<Pair<String,Double>> generatePayslip(LocalDate startDate, LocalDate endDate) {
        List<Attendance> attendances = attendanceRepository.findAllByDateBetween(startDate,endDate);
        Map<Employee,List<Attendance>> employeeListMap = attendances.stream().collect(Collectors.groupingBy(r -> r.getEmployee()));
        List<Pair<String,Double>> salaries = employeeListMap.entrySet().stream()
                .map(entry -> {
                    Double totalWorkingHours = entry.getValue().stream().map(a -> a.getHoursWorked()).mapToDouble(Double::doubleValue).sum();
                    double overtimeHours = overtimeRepository.findAllByEmployeeId(entry.getKey().getId()).stream().map(o -> o.getOvertimeHours()).mapToDouble(Double::doubleValue).sum();
                    totalWorkingHours = totalWorkingHours +  overtimeHours;
                    totalWorkingHours = totalWorkingHours * entry.getKey().getSalary();
                    return Pair.of(entry.getKey().getEmail(),totalWorkingHours);
                }).collect(Collectors.toList());
        return salaries;
    }
}