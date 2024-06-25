package com.ohgiraffers.common;

@Data
public class BoardDTO {

    private Long id;
    private String title;
    private String content;
    private MemberDTO writer;
}
