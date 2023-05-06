package ua.com.hotel.hotelpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.hotel.hotelpractice.entity.Users;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByUsername(String name);

    Users findByUsername(String name);
}