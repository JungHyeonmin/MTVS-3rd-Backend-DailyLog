package com.ohgiraffers.restapi.section03.valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
    
    @ExceptionHandler(UserNotFoundExceoption.class)// 매핑할 타입
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundExceoption e) {

        String code = "ERROR_CODE_00000";
        String description = "회원 정보 조회 실패";
        String detail = e.getMessage();

        return new ResponseEntity<>(new ErrorResponse(code, description, detail), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodValidException(MethodArgumentNotValidException e) {

        String code = "";
        String description = "";
        String detail = "";

        // 에러가 있다면
        if (e.getBindingResult().hasErrors()) {
            detail = e.getBindingResult().getFieldError().getDefaultMessage();

            String bindResultCode = e.getBindingResult().getFieldError().getCode();
            switch (bindResultCode) {
                case "NotNull":
                    code = "ERROR_CODE_O0001";
                    description = "필수 앖이 누락되었습니다.";
                    break;
            }
        }

        ErrorResponse errorResponse = new ErrorResponse(code, description, detail);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
