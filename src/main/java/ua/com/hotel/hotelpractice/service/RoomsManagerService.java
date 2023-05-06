package ua.com.hotel.hotelpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hotel.hotelpractice.entity.Category;
import ua.com.hotel.hotelpractice.entity.Rooms;
import ua.com.hotel.hotelpractice.repository.RoomsRepository;

import java.util.List;

@Service
public class RoomsManagerService {

    private final RoomsRepository roomsRepository;

    @Autowired
    public RoomsManagerService(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    public void saveNewRoomsToDB(String name, String description, String image, Double price, Category category, int sumSits) {

        Rooms rooms = new Rooms();
        rooms.setName(name);
        rooms.setDescription(description);
        rooms.setImage(image);
        rooms.setPrice(price);
        rooms.setCategories(category);
        rooms.setSumSits(sumSits);

        roomsRepository.save(rooms);
    }

    public void updateRooms(Long id, String name, String description, String image, Double price, Category category, int sumSits) {
        Rooms rooms = new Rooms();
        rooms.setId(id);
        rooms.setName(name);
        rooms.setDescription(description);
        rooms.setImage(image);
        rooms.setPrice(price);
        rooms.setCategories(category);
        rooms.setSumSits(sumSits);

        roomsRepository.save(rooms);
    }


    public void deleteRoomsById(Long id) {
        roomsRepository.deleteById(id);
    }

    public void deleteAllRooms() {
        roomsRepository.deleteAll();
    }

    public List<Rooms> findAllRooms() {
        return roomsRepository.findAll();
    }

    public Rooms findRoomsById(Long id) {
        return roomsRepository.findById(id).get();
    }

    public Rooms findRoomsByName(String name) {
        return roomsRepository.findByName(name);
    }

    public boolean sizeRoomsByCategory(Category category) {
        List<Rooms> rooms = roomsRepository.findAllByCategories(category);
        return rooms.size() > 0;
    }
}