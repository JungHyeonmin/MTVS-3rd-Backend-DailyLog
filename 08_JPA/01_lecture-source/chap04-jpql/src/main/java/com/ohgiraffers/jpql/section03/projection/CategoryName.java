package com.ohgiraffers.jpql.section03.projection;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CategoryName {

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    public CategoryName() {
    }
    
    public CategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return "CategoryName{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }
}
