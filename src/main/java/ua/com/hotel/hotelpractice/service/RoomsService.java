package ua.com.hotel.hotelpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hotel.hotelpractice.entity.Category;
import ua.com.hotel.hotelpractice.entity.Rooms;
import ua.com.hotel.hotelpractice.repository.RoomsRepository;

import java.util.List;

@Service
public class RoomsService {
    private final RoomsRepository roomsRepository;

    @Autowired
    public RoomsService(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    public List<Rooms> getAllRooms() {
        return roomsRepository.findAll();
    }

    public Rooms getRoomsById(Long id) {
        return roomsRepository.getById(id);
    }

    public List<Rooms> findAllRoomsByCategory(Category category) {
        return roomsRepository.findAllByCategories(category);
    }

    public List<Rooms> getAllRoomsByName(String name){
        return roomsRepository.getAllByName(name);
    }
}

