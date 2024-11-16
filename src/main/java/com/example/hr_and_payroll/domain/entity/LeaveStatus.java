package com.example.hr_and_payroll.domain.entity;

import java.util.Arrays;

public enum LeaveStatus {
    APPROVED("Approved"),
    PENDING("Pending"),
    REJECTED("Rejected");

    private String value;

    LeaveStatus(String value) {
        this.value = value;
    }

    public static LeaveStatus fromValue(String val){
        return Arrays.stream(LeaveStatus.values())
                .filter(v -> v.value.equals(val)).findFirst().orElse(null);
    }
}
