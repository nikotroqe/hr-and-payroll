package com.example.hr_and_payroll.mapper;

import com.example.hr_and_payroll.domain.dto.AttendanceDTO;
import com.example.hr_and_payroll.domain.entity.Attendance;
import com.example.hr_and_payroll.domain.entity.AttendanceStatus;
import com.example.hr_and_payroll.domain.entity.Employee;

import java.time.LocalTime;

public class AttendanceMapper {
    public static AttendanceDTO mapToAttendanceDto(Attendance attendance){
        return new AttendanceDTO(
                attendance.getId(),
                attendance.getEmployee().getId(),
                attendance.getDate(),
                attendance.getCheckInTime().toString(),
                attendance.getCheckOutTime().toString(),
                attendance.getHoursWorked(),
                attendance.getStatus().name()
        );
    }
    public static Attendance mapToAttendance(AttendanceDTO attendanceDTO){
        return new Attendance(
                new Employee(attendanceDTO.getEmployeeId()),
                attendanceDTO.getDate(),
                LocalTime.parse(attendanceDTO.getCheckInTime()),
                LocalTime.parse(attendanceDTO.getCheckOutTime()),
                attendanceDTO.getHoursWorked(),
                AttendanceStatus.fromValue(attendanceDTO.getStatus())
        );
    }
}
