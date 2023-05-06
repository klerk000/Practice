package ua.com.hotel.hotelpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.hotel.hotelpractice.entity.Category;
import ua.com.hotel.hotelpractice.entity.Rooms;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Long> {

    @Override
    List<Rooms> findAll();

    Rooms findByName(String name);

    Rooms getById(Long id);

    List<Rooms> findAllByCategories(Category category);

    List<Rooms> getAllByName(String name);
}