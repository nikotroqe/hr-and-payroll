package com.example.hr_and_payroll.controller;

import com.example.hr_and_payroll.domain.dto.OvertimeDTO;
import com.example.hr_and_payroll.domain.entity.Overtime;
import com.example.hr_and_payroll.service.OvertimeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/overtime")
public class OvertimeController {
    private final OvertimeService overtimeService;
    @PostMapping("/create")
    public ResponseEntity<OvertimeDTO> createOvertime(@RequestBody OvertimeDTO overtimeDTO){
        OvertimeDTO savedOvertime = overtimeService.createOvertime(overtimeDTO);
        return new ResponseEntity<>(savedOvertime, HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<OvertimeDTO> getOvertimeById(@PathVariable("id") Integer overtimeId){
        OvertimeDTO overtimeDTO = overtimeService.getOvertimeById(overtimeId);
        return ResponseEntity.ok(overtimeDTO);
    }
    @GetMapping("/list")
    public Page<Overtime> listOvertime(
            @Valid @RequestParam Map<String, Object> filterRequest,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {

        return overtimeService.getAllOvertime1(filterRequest,page, size, sort);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OvertimeDTO> updateOvertime(@PathVariable("id") Integer overtimeId,
                                                      @RequestBody OvertimeDTO updatedOvertime){
        OvertimeDTO overtimeDTO = overtimeService.updateOvertime(overtimeId, updatedOvertime);
        return ResponseEntity.ok(overtimeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOvertime(@PathVariable("id") Integer overtimeId){
        overtimeService.deleteOvertime(overtimeId);
        return ResponseEntity.ok("Overtime deleted successfully!.");
    }
}
