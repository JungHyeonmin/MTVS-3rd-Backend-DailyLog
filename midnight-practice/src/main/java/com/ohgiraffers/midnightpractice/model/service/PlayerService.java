package com.ohgiraffers.midnightpractice.model.service;

import com.ohgiraffers.midnightpractice.model.Player;
import com.ohgiraffers.midnightpractice.model.repository.PlayerRepository;
import com.ohgiraffers.midnightpractice.model.dto.playerdto.FoundPlayerResponseDTO;
import com.ohgiraffers.midnightpractice.model.dto.playerdto.PlayerRegistRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    // 플레이어 생성
    @Transactional
    public void registNewPlayer(PlayerRegistRequestDTO playerInfo) {
        Player newPlayer = new Player(
                playerInfo.getPlayerName(),
                playerInfo.getPlayerLevel()
        );
        playerRepository.save(newPlayer);
    }

    // 전체 플레이어 조회
    public List<FoundPlayerResponseDTO> findAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(FoundPlayerResponseDTO::new)
                .toList();
    }

    // 수정
    public void modifyPlayerName(Long playerNo, String newPlayerName) {
        Player foundPlayer = playerRepository.findById(playerNo)
                .orElseThrow(IllegalAccessError::new);
        foundPlayer.setPlayerName(newPlayerName);
    }

    // 삭제
    public void removePlayer(Long playerId) {
        playerRepository.deleteById(playerId);
    }
}

