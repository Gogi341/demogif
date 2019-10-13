package com.mg.gifdemo.repository;

import com.mg.gifdemo.model.Category;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(0, "funny"),
            new Category(0, "sport"),
            new Category(0, "it")
            );

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }
}