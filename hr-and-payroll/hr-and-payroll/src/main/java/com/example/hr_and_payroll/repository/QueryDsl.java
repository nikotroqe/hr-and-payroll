package com.example.hr_and_payroll.repository;


import com.querydsl.core.types.Predicate;

public interface QueryDsl<K> {
    Predicate filter(K filter);
}
