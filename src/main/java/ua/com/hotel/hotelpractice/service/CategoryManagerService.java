package ua.com.hotel.hotelpractice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hotel.hotelpractice.entity.Category;
import ua.com.hotel.hotelpractice.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryManagerService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryManagerService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public void saveCategory(String name, String descr, String image) {

        Category category = new Category();
        category.setName(name);
        category.setDescription(descr);
        category.setImage(image);

        categoryRepository.save(category);
    }

    public void updateCategory(Long id, String name, String descr, String image) {

        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setDescription(descr);
        category.setImage(image);

        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }


    public void deleteAllCategory() {
        categoryRepository.deleteAll();
    }


    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {

        Optional<Category> categories = categoryRepository.findById(id);

        if (categories.isEmpty()) {
            return null;
        } else {
            return categories.get();
        }
    }

    public Category getCategoryByName(String name) {

        return categoryRepository.findByName(name);
    }
}