package com.ohgiraffers.common;


public class MemberDTO {

    private int sequence;
    private String id;
    private String pwd;
    private String name;

    public MemberDTO() {
    }

    public MemberDTO(int sequence, String id, String pwd, String name) {
        this.sequence = sequence; // 고유한 숫자나 식별자
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
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

    @Override
    public String toString() {
        return "MemberDTO{" +
                "sequence=" + sequence +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
