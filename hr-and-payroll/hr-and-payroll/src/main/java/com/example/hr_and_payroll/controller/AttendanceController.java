package com.example.hr_and_payroll.controller;

import com.example.hr_and_payroll.domain.dto.AttendanceDTO;
import com.example.hr_and_payroll.domain.entity.Attendance;
import com.example.hr_and_payroll.service.AttendanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/create")
    public ResponseEntity<AttendanceDTO> createAttendance(@RequestBody AttendanceDTO attendanceDTO){
        AttendanceDTO savedAttendance = attendanceService.createAttendance(attendanceDTO);
        return new ResponseEntity<>(savedAttendance, HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<AttendanceDTO> getAttendanceById(@PathVariable("id") Integer attendanceId){
        AttendanceDTO attendanceDTO = attendanceService.getAttendanceById(attendanceId);
        return ResponseEntity.ok(attendanceDTO);
    }

    @GetMapping("/list")
    public Page<Attendance> listAttendance(
            @Valid @RequestParam Map<String, Object> filterRequest,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String sort
    ) {
        return attendanceService.getAllAttendance1(filterRequest, page, size, sort);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AttendanceDTO> updateAttendance(@PathVariable("id") Integer attendanceId,
                                                    @RequestBody AttendanceDTO updateAttendance){
        AttendanceDTO attendanceDTO = attendanceService.updateAttendance(attendanceId, updateAttendance);
        return ResponseEntity.ok(attendanceDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAttendance(@PathVariable("id") Integer attendanceId){
        attendanceService.deleteAttendance(attendanceId);
        return ResponseEntity.ok("Attendance deleted successfully!.");
    }
}
