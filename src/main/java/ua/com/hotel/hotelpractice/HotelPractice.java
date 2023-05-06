package ua.com.hotel.hotelpractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.com.hotel.hotelpractice.entity.Category;
import ua.com.hotel.hotelpractice.entity.Role;
import ua.com.hotel.hotelpractice.repository.CategoryRepository;
import ua.com.hotel.hotelpractice.repository.RoleRepository;

@SpringBootApplication
public class HotelPractice {

    public static void main(String[] args) {
        SpringApplication.run(HotelPractice.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, CategoryRepository categoryRepository) {
        return args -> {
            if (roleRepository.findAll().isEmpty()) {
                roleRepository.save(new Role(1L, "ROLE_User"));
                roleRepository.save(new Role(2L, "ROLE_Manager"));
                roleRepository.save(new Role(3L, "ROLE_Admin"));
            }
            if (categoryRepository.findAll().isEmpty()){
                categoryRepository.save(new Category(
                        1L,
                        "Бомж кімната",
                        "Якщо вас не вбьють буде добре",
                        "../images/category/bomz.jpg"));

                categoryRepository.save(new Category(
                        2L,
                        "Економ",
                        "Дешеві кімнати",
                        "../images/category/eco.jpg"));

                categoryRepository.save(new Category(
                        3L,
                        "Прості кімнати",
                        "Звичайні кімнати. Нічого особливого, проте і без негативу",
                        "../images/category/simple.jpg"));

                categoryRepository.save(new Category(
                        4L,
                        "Лакшері",
                        "Цілі будинки(а може й вулиці), дорого-богато і дуже комфортно(Служанки в комлекті)",
                        "../images/category/luxury.jpg"));
            }
        };
    }
}