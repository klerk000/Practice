package ua.com.hotel.hotelpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.hotel.hotelpractice.entity.Category;
import ua.com.hotel.hotelpractice.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public String getPageHome(Model model) {

        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("allCategory", categoryList);
        return "category";
    }
}