package com.ohgiraffers.jpql.section03.projection;

// 조회할때 사용
public class CategoryInfo {

    private int categoryCode;
    private CategoryName categoryName;

    public CategoryInfo() {
        
    }

    public CategoryInfo(int categoryCode, CategoryName categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryInfo{" +
                "categoryCode=" + categoryCode +
                ", categoryName=" + categoryName +
                '}';
    }
}
