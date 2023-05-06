package ua.com.hotel.hotelpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.hotel.hotelpractice.entity.Rooms;
import ua.com.hotel.hotelpractice.service.CategoryService;
import ua.com.hotel.hotelpractice.service.RoomsService;

import java.util.List;

@Controller
public class RoomsController {

    private final RoomsService roomsService;
    public final CategoryService categoryService;

    @Autowired
    public RoomsController(RoomsService roomsService, CategoryService categoryService) {
        this.roomsService = roomsService;
        this.categoryService = categoryService;
    }

    @GetMapping("/rooms")
    public String getRoomsList(Model model) {

        List<Rooms> roomsList = roomsService.getAllRooms();
        model.addAttribute("rooms", roomsList);
        model.addAttribute("title", "Всі кімнати");

        return "rooms";
    }

    @GetMapping("/category/rooms/{id}")
    public String getRoomsByCategory(@PathVariable("id") Long id,
                                     Model model) {

        List<Rooms> roomsList = roomsService.findAllRoomsByCategory(categoryService.getCategoryById(id));
        model.addAttribute("rooms", roomsList);
        model.addAttribute("title", "Кімнати вибраної категорії");

        return "rooms";
    }

    @GetMapping("/room/{id}")
    public String getRoomById(@PathVariable("id") Long id,
                              Model model) {
        Rooms rooms = roomsService.getRoomsById(id);
        model.addAttribute("room", rooms);

        return "room";
    }
}
