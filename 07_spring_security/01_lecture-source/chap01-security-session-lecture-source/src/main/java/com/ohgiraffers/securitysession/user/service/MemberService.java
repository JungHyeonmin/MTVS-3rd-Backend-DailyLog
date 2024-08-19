package com.ohgiraffers.securitysession.user.service;

import com.ohgiraffers.securitysession.user.dao.UserMapper;
import com.ohgiraffers.securitysession.user.model.dto.LoginUserDTO;
import com.ohgiraffers.securitysession.user.model.dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.Objects;

@Service
public class MemberService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Transactional
    public Integer regist(SignupDTO signupDTO) {

        signupDTO.setUserPass(encoder.encode(signupDTO.getUserPass()));
        Integer result = null;

        try{
            result = userMapper.regist(signupDTO);
        }catch (DuplicateKeyException e){
            e.printStackTrace();
        }catch (BadSqlGrammarException e) {
            result = 0;
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 사용자의 id를 입력받아 DB에서 회원을 조회하는 메서드
     * @param username : 사용자 id
     * @return LoginUserDTO : LoginUserDTO 사용자 개체
     * */
    public LoginUserDTO findByUsername(String username) {

        LoginUserDTO login = userMapper.findByUsername(username);

        if(!Objects.isNull(login)){
            return login;
        }else{
            return  null;
        }
    }
}
