package ua.com.hotel.hotelpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.hotel.hotelpractice.entity.RoomsHasOrder;

@Repository
public interface RoomsHasOrderRepository extends JpaRepository<RoomsHasOrder, Long> {
}