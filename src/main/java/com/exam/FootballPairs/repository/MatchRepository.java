package com.exam.FootballPairs.repository;

import com.exam.FootballPairs.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
