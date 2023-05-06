package ua.com.hotel.hotelpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.hotel.hotelpractice.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    List<Category> findAll();

    Category findByName(String name);

    Category findCategoryById(Long id);

    List<Category> getAllByName(String name);
}