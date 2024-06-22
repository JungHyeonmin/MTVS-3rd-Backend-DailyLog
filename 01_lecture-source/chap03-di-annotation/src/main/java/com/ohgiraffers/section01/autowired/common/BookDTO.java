package com.ohgiraffers.section01.autowired.common;

import java.util.Date;

public class BookDTO {

    private int sequence;
    private int isbn;
    private String title;
    private String author;
    private String publisher;
    private Date createdDate;

    public BookDTO(int sequence, int isbn, String title, String author, String publisher, Date createdDate) {
        this.sequence = sequence;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.createdDate = createdDate;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "sequence=" + sequence +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
