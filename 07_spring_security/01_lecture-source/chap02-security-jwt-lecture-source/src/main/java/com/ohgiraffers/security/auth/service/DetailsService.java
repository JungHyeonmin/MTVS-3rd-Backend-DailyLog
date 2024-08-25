package com.ohgiraffers.security.auth.service;

import com.ohgiraffers.security.auth.model.DetailsUser;
import com.ohgiraffers.security.user.service.UserService;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 로그인 요청시 사용자의 정보를 조회하는 클래스
 * */
@Service
public class DetailsService implements UserDetailsService {

    private final UserService userService;

    public DetailsService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 로그인 요청시 사용자의 id를 받아 DB에서 사용자의 정보를 가져온다.
     * @param username - 사용자 id
     * @return UserDetials - 사용자 entity
     * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(username == null || username.equals("")){
            throw  new AuthenticationServiceException(username+" is Empty");
        }else{
            return userService.findUser(username)
                    .map(data -> new DetailsUser(Optional.of(data)))
                    .orElseThrow(() -> new AuthenticationServiceException(username));
        }
    }
}
