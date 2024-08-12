package com.ohgiraffers.restapi.section03.valid;

import jakarta.validation.constraints.*;

import java.util.Date;

public class UserDTO {

    private int no;

    //    @NotNull(message = "아이디는 반드시 입력되어야 합니다.")   // null을 허용하지 않는다. "", " "는 허용한다.
//    @NotEmpty(message = "") //null, ""를 허용하지 않는다. " "는 허용합니다.
    @NotBlank(message = "아이디는 공백일 수 없습니다.")     // null, "", " " 모두 허용하지 않는다.
    private String id;
    private String pwd;

    @NotNull(message = "이름은 반드시 입력되어야 합니다.")
    @Size(min = 2, message = "이름은 2글자 이상 입력해야 합니다.")
//    @Min(value=2)
//    @Max(value=10)
    private String name;

    @Past       //현재 보다 과거
//    @Future     //현재보다 미래
    private java.util.Date enrollDate;

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

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
