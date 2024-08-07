package com.ohgiraffers.jpql.section03.projection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectionService {

    private ProjectionRepository projectionRepository;

    @Autowired
    public ProjectionService(ProjectionRepository projectionRepository) {
        this.projectionRepository = projectionRepository;
    }

    public List<Menu> findAllMenusWithEntityProjection() {

        return projectionRepository.findAllMenusWithEntityProjection();
    }

    public List<CategoryName> findAllCategoriesEmbeddedTypeProjection() {

        return projectionRepository.findAllCategoriesEmbeddedTypeProjection();
    }

    public List<Integer> findAllCategoriesWithScalarProjection() {

        return projectionRepository.findAllCategoriesWithScalarProjection();
    }

    public List<Object[]> findAllCategoryCodesAndNames() {
        return projectionRepository.findAllCategoryCodesAndNames();
    }

    public List<CategoryInfo> findAllCategoryNameWithNew() {

        return projectionRepository.findAllCategoryNameWithNew();
    }
}
