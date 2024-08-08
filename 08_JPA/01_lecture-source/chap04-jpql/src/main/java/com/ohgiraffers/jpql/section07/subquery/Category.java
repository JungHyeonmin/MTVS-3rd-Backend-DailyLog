package com.ohgiraffers.jpql.section07.subquery;

import com.ohgiraffers.jpql.section03.projection.CategoryName;
import jakarta.persistence.*;

@Entity(name="Section07Category")
@Table(name="TBL_CATEGORY")
public class Category {

    @Id
    @Column(name="CATEGORY_CODE")
    private int categoryCode;

    @Column(name="CATEGORY_NAME")
    private String categoryName;

    @Column(name="REF_CATEGORY_CODE")
    private Integer refCategoryCode;

    protected Category() {}

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
                ", categoryName=" + categoryName +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}