package com.ohgiraffers.setion01.javaconfig;


import org.apache.ibatis.annotations.Select;

public interface Mapper {

    // sql 문 작성 가능 어노테이션 (수행해야 할 액션(어떤 액선?))
    @Select("SELECT CURDATE() FROM DUAL")
    java.util.Date selectSysdate();
}
