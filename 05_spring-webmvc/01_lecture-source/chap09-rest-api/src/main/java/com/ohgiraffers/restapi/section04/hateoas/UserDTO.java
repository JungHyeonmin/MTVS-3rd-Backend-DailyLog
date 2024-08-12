package com.ohgiraffers.restapi.section04.hateoas;

import java.util.Date;

public class UserDTO {

    private int no;
    private String id;
    private String pwd;
    private String name;
    private java.util.Date date;

    public UserDTO() {
    }

    public UserDTO(int no, String id, String pwd, String name, Date date) {
        this.no = no;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.date = date;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
