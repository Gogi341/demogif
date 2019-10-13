package com.mg.gifdemo.controller;

import com.mg.gifdemo.model.Category;
import com.mg.gifdemo.model.Gif;
import com.mg.gifdemo.repository.CategoryRepository;
import com.mg.gifdemo.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GifRepository gifRepository;

    @GetMapping("/categories")
    public String gifCategories(ModelMap modelMap){

        //1. Wyciąganie kategorii

        List <Category> categories = categoryRepository.getAllCategories();

        //2. Przekazywanie kategorii do View
        modelMap.put("categories", categories); // tu dokonaliśmy mapowania, na frontendzie szukamy $ - on zaznacza pobierane dane z BackEnd

        //3. Zwracanie nazwy widoku
        return "categories";

    }

    @GetMapping("/category/{id}")
    public String getGifsByCategory(@PathVariable int id, ModelMap modelMap){

        //1. Wyciąganie potrzebnych obiektów
        // pobieramy listę gifów należących do danej kategorii

        List<Gif> gifList = gifRepository.getGifsByCategoryId(id);
        Category category = categoryRepository.getCategoryById(id);

        //2. Przekazywanie kategorii do View
        modelMap.put("gifs", gifList);
        modelMap.put("category", category);

        //3. Zwracanie nazwy widoku
        return "category";
    }
}
