package com.ohgiraffers.restapi.section03.valid;

public class ErrorResponse {

    private String code;
    private String description;
    private String detail;

    public ErrorResponse() {

    }
    
    public ErrorResponse(String detail, String description, String code) {
        this.detail = detail;
        this.description = description;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
