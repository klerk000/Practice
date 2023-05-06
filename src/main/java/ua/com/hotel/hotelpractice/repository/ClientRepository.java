package ua.com.hotel.hotelpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.hotel.hotelpractice.entity.Client;
import ua.com.hotel.hotelpractice.entity.Users;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client getClientById(Long id);

    Client findByUsers(Users users);
}