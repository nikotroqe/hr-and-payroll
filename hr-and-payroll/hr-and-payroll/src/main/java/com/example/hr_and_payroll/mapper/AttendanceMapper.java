package com.example.hr_and_payroll.mapper;

import com.example.hr_and_payroll.domain.dto.AttendanceDTO;
import com.example.hr_and_payroll.domain.entity.Attendance;
import com.example.hr_and_payroll.domain.entity.AttendanceStatus;
import com.example.hr_and_payroll.domain.entity.Employee;

public class AttendanceMapper {
    public static AttendanceDTO mapToAttendanceDto(Attendance attendance){
        return new AttendanceDTO(
                attendance.getId(),
                attendance.getEmployee().getId(),
                attendance.getDate(),
                attendance.getCheckInTime(),
                attendance.getCheckOutTime(),
                attendance.getHoursWorked(),
                attendance.getOvertimeHours()
        );
    }
    public static Attendance mapToAttendance(AttendanceDTO attendanceDTO){
        return new Attendance(
                new Employee(attendanceDTO.getEmployeeId()),
                attendanceDTO.getDate(),
                attendanceDTO.getCheckInTime(),
                attendanceDTO.getCheckOutTime(),
                attendanceDTO.getHoursWorked(),
                attendanceDTO.getOvertimeHours(),
                AttendanceStatus.PRESENT
        );
    }
}
