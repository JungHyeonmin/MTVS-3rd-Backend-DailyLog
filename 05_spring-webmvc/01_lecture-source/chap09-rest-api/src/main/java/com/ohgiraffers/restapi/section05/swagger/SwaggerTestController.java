package com.ohgiraffers.restapi.section05.swagger;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 스웨거 UI에 표시될 이름과 설명을 정의
@Tag(name = "SWAGGER 테스트 컨트롤러", description = "스웨거 테스트 컨트롤러입니다.")
@RestController // 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타낸다.
@RequestMapping("/swagger") // 모든 핸들러 메서드의 기본 URL 경로를 /swagger 로 설정
public class SwaggerTestController {

    private List<UserDTO> users;

    // 생성자
    public SwaggerTestController() {
        users = new ArrayList<>();

        users.add(new UserDTO(1, "user01", "pass01", "홍길동", new java.util.Date()));
        users.add(new UserDTO(2, "user02", "pass02", "유관순", new java.util.Date()));
        users.add(new UserDTO(3, "user03", "pass03", "이순신", new java.util.Date()));
    }


    @GetMapping("/users")
    // 메서드 레벨에서 사용하여 해당 API 오퍼레이션의 요약과 설명을 제공한다.
    @Operation(summary = "USER 목록 조회", description = "유저 목록 전체를 조회합니다.")
    // ResponseEntity : 요청에 대한 응답을 객체로 만듦
    public ResponseEntity<ResponseMessage> findAllUsers() {

        // HttpHeaders: HTTP 요청과 응답을 위한 헤더 정보를 캡슉화 하는 클래스application
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        // 이부분이 사실상 AI서버에 값을 그대로 전달하고 반환받은 값을 List라고 생각하고 Map 형태로 저장 후 xr에 반환 => 내가 할 일은 AI 서버에 요청하기(받은 json 형태로 그대로 전달 내가 메서드 요청하면서 전달)

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);

        // 유니티로 넘겨줄게 코드 작성(PostMapping) => 유니티로 어떻게 보내지?-> 유니티로 보내기 위해서는 어떤 정보가 필요하지?
        //      -> 유니티가 달라고 요청을 하면 보내준다.
        // XR에게 반환하는 값
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }
/*
    @PostMapping("/postUser")
    public ResponseEntity<ResponseMessage> postUser(@RequestBody UserDTO userDTO) {
        // HttpHeaders: HTTP 요청과 응답을 위한 헤더 정보를 캡슉화 하는 클래스application
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("userPwd", userDTO.getPwd());

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);

        // 유니티로 넘겨줄게 코드 작성(PostMapping)

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }*/
}
