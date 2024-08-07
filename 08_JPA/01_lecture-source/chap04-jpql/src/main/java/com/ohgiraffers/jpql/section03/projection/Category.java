package com.ohgiraffers.jpql.section03.projection;

import jakarta.persistence.*;

@Entity(name = "Section03Category")
@Table(name = "TBL_CATEGORY")
public class Category {

    @Id
    @Column(name = "CATEGORY_CODE")
    private int categoryCode;

    @Embedded
    private CategoryName categoryName;

    @Column(name = "REF_CATEGORY_CODE")
    private Integer refCategoryCode;

    public Category() {
    }

    public Category(int categoryCode, CategoryName categoryName, Integer refCategoryCode) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName=" + categoryName +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
