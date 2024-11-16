package com.example.hr_and_payroll.domain.entity;

import java.util.Arrays;

public enum AttendanceStatus {
    PRESENT("Present"),
    ABSENT("Absent"),
    ON_LEAVE("On_Leave"),
    OVERTIME_PENDING_APPROVAL("Overtime_Pending_Approval"),
    OVERTIME_APPROVED("Overtime_Approved");

    private String value;

    AttendanceStatus(String value) {
        this.value = value;
    }

    public static AttendanceStatus fromValue(String val){
        return Arrays.stream(AttendanceStatus.values())
                .filter(v -> v.value.equals(val)).findFirst().orElse(null);
    }
}
