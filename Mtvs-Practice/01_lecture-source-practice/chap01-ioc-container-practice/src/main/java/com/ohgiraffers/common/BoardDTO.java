package com.ohgiraffers.common;

// DTO : 프로세스 간에 데이터를 전달하는 객체
// 저장할 책 객체를 만드는 DTO클래스
public class BoardDTO {
    private Long id;        // 아이디
    private String title;   // 제목
    private String content; // 내용
    private String writer;  // 작성자

    // 생성자
    public BoardDTO(Long id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    // getter & setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    // toString
    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
