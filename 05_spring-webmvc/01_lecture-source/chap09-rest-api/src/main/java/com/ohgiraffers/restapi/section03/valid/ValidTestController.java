package com.ohgiraffers.restapi.section03.valid;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

// 검증 클래스
@RestController
@RequestMapping("/valid")
public class ValidTestController {

    @GetMapping("/users/{userNo}")
    public ResponseEntity<?> findUserByNo(@PathVariable("userNo") int userNo) throws UserNotFoundExceoption {

        boolean check = true; // 컴파일러를 속이기 위한 코드
        if (true) {
            throw new UserNotFoundExceoption("회원 정보를 찾을 수 없습니다.");
        }


        return ResponseEntity.ok().build();
    }

    @PostMapping("/users")
    public ResponseEntity<?> registUser(@Valid @RequestBody UserDTO user) {

        return ResponseEntity.created(URI.create("/valid/users/" + 1)).build();
    }
}
