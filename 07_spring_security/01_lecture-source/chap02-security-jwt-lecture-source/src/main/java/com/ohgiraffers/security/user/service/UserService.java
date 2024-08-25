package com.ohgiraffers.security.user.service;

import com.ohgiraffers.security.user.entity.User;
import com.ohgiraffers.security.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(String id){
        Optional<User> user = userRepository.findByUserId(id);


        return user;
    }
}
