package com.ohgiraffers.section01.autowired.common;

import java.util.Date;

// 책 객체 생성 클래스
public class BookDTO {
    private int sequence;
    private int isbn;
    private String title;
    private String author;
    private String publisher;

    private Date creaedDate;

    public BookDTO(int sequence, int isbn, String title, String author, String publisher, Date creaedDate) {
        this.sequence = sequence;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.creaedDate = creaedDate;
    }

    public Date getCreaedDate() {
        return creaedDate;
    }

    public void setCreaedDate(Date creaedDate) {
        this.creaedDate = creaedDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "sequence=" + sequence +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", creaedDate=" + creaedDate +
                '}';
    }
}
