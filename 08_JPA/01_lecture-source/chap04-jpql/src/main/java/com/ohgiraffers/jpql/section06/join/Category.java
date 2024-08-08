package com.ohgiraffers.jpql.section06.join;

import jakarta.persistence.*;

        import java.util.List;

@Entity(name="Section06Category")
@Table(name="TBL_CATEGORY")
public class Category {

    @Id
    @Column(name="CATEGORY_CODE")
    private int categoryCode;

    @Column(name="CATEGORY_NAME")
    private String categoryName;

    @Column(name="REF_CATEGORY_CODE")
    private Integer refCategoryCode;

    @OneToMany(mappedBy = "category")
    //연관관계 주인이 아닌 경우 mappedBy를 붙인다.(FK가 있는 경우가 주인)
    private List<Menu> menuList;

    protected Category() {}

    public Category(int categoryCode, String categoryName, Integer refCategoryCode, List<Menu> menuList) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
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

    public List<Menu> getMenuList() {
        return menuList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                // ", menuList=" + menuList + // Menu 의 toString() 을 호출해서 무한 반복하기 때문에 주석처리한다.
//                ", menuList=" + menuList +
                '}';
    }
}