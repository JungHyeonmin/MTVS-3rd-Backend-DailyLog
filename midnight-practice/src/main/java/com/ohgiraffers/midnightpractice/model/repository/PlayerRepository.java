package com.ohgiraffers.midnightpractice.model.repository;


import com.ohgiraffers.midnightpractice.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
