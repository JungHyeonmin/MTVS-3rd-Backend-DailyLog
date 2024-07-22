package com.ohgiraffers.mvcpractice.model.service;

import com.ohgiraffers.mvcpractice.model.dao.LoginMapper;
import com.ohgiraffers.mvcpractice.model.dto.PlayerDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    LoginMapper loginMapper;

    public LoginService(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }


    public PlayerDTO checkPlayer(PlayerDTO playerDTO) {

        Map<String, String> player = new HashMap<>();

        player.put("playerName", playerDTO.getPlayerName());
        player.put("playerPassword", playerDTO.getPlayerPassword());

        return loginMapper.findPlayer(player);
    }
}
