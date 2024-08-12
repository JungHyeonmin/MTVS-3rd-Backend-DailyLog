package com.ohgiraffers.restapi.section01.response;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/response")
public class ResponseRestController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world!";
    }

    @GetMapping("/random")
    public int getRandomNumber() {

        return (int) (Math.random() * 10) + 1;
    }

    // Spring 에서는 JackSon 을 기본적으로 dependency 해서 사용한다.
    @GetMapping("/message")
    public Message getMessage() {

        return new Message(200, "메세지를 응답합니다.");

    }

    @GetMapping("/list")
    public List<String> getList() {

        return List.of(new String[]{"사과", "바나나", "복숭아"});
    }

    @GetMapping("/map")
    public Map<Integer, String> getMap() {

        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(200, "정상 응답"));
        messageList.add(new Message(404, "페이지를 찾을 수 없습니다."));
        messageList.add(new Message(500, "개발자의 잘못입니다."));

        // List 에서 Map 으로 변환
        return messageList
                .stream()
                .collect(Collectors.toMap(Message::getHttpStatusCode, Message::getMessage));
    }

    //produces :
    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage() throws IOException {
        return new FileInputStream(new File("C:\\Lecture\\subject\\MTVS-3rd-Backend-DailyLog\\05_spring-webmvc\\01_lecture-source\\chap09-rest-api\\src\\main\\java\\com\\ohgiraffers\\restapi\\section01\\response\\sample.png"))
                .readAllBytes();
    }


    @GetMapping("/entity")

    public ResponseEntity<Message> getEntity() {

        return ResponseEntity.ok(new Message(123, "helloWorld!"));

    }
}