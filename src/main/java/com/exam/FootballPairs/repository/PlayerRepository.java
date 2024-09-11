package com.exam.FootballPairs.repository;

import com.exam.FootballPairs.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
