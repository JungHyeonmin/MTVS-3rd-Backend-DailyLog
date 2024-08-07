package com.ohgiraffers.association.section01.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_category")
public class Category {

    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;


    public Category() {
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }


    public int getCategoryCode() {
        return categoryCode;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
