package com.example.hr_and_payroll.domain.entity;

import java.util.Arrays;

public enum LeaveType {
    SICK_LEAVE("Stick_Leave"),
    VACATION("Vacation"),
    UNPAID_LEAVE("Unpaid_Leave"),
    OTHER("Other");

    private String value;

    LeaveType(String value) {
        this.value = value;
    }

    public static LeaveType fromValue(String val){
        return Arrays.stream(LeaveType.values())
                .filter(v -> v.value.equals(val)).findFirst().orElse(null);
    }
}
