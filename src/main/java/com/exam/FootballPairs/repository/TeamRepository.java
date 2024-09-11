package com.exam.FootballPairs.repository;

import com.exam.FootballPairs.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
