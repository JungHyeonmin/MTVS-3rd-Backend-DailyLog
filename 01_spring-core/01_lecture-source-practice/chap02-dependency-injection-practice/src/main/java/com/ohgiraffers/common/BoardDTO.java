package com.ohgiraffers.common;


public class BoardDTO {

    private Long id;
    private String title;
    private String content;
    private MemberDTO writer;

    public BoardDTO(Long id, String title, String content, MemberDTO writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

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

    public MemberDTO getWriter() {
        return writer;
    }

    public void setWriter(MemberDTO writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer=" + writer +
                '}';
    }
}
