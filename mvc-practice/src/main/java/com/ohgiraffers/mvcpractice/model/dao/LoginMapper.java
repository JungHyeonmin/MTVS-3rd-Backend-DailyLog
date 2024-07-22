package com.ohgiraffers.mvcpractice.model.dao;

import com.ohgiraffers.mvcpractice.model.dto.PlayerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LoginMapper {

    PlayerDTO findPlayer(Map<String, String> player);
}
