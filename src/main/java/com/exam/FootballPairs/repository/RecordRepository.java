package com.exam.FootballPairs.repository;


import com.exam.FootballPairs.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
