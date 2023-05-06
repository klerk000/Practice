package ua.com.hotel.hotelpractice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.hotel.hotelpractice.entity.Category;
import ua.com.hotel.hotelpractice.entity.Rooms;
import ua.com.hotel.hotelpractice.service.CategoryManagerService;
import ua.com.hotel.hotelpractice.service.RoomsManagerService;


@Controller
public class RoomsManagerController {

    private final RoomsManagerService roomsManagerService;
    private final CategoryManagerService categoryManagerService;

    @Autowired
    public RoomsManagerController(RoomsManagerService roomsManagerService, CategoryManagerService categoryManagerService) {
        this.roomsManagerService = roomsManagerService;
        this.categoryManagerService = categoryManagerService;
    }


    @GetMapping("/roomsManager")
    public String getAllRooms(Model model) {

        model.addAttribute("allRooms", roomsManagerService.findAllRooms());
        model.addAttribute("allCategory", categoryManagerService.getCategoryList());

        return "roomsAdminPage";
    }


    @PostMapping("/saveNewRooms")
    public String saveNewRoomsToDB(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "description") String descr,
                                   @RequestParam(value = "image") String image,
                                   @RequestParam(value = "price") Double price,
                                   @RequestParam(value = "categoryId") Category category,
                                   @RequestParam(value = "sumSits") Integer sumSits
    ) {

        roomsManagerService.saveNewRoomsToDB(name, descr, image, price, category, sumSits);

        return "redirect:/roomsManager";
    }


    @PostMapping("/updateRooms")
    public String updateProduct(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "description") String descr,
            @RequestParam(value = "image") String image,
            @RequestParam(value = "price") String price1,
            @RequestParam(value = "categoryId") Category category,
            @RequestParam(value = "sumSits") String sumSits1
    ) {

        Double price = Double.parseDouble(price1.replaceAll("[^0-9]", ""));

        int sumSits =
                Integer.parseInt(sumSits1.replaceAll("[^0-9]", ""));

        roomsManagerService.updateRooms(id, name, descr, image, price, category, sumSits);

        return "redirect:/roomsManager";
    }


    @PostMapping("/deleteRooms")
    public String deleteProduct(@RequestParam(value = "id") Long id) {

        roomsManagerService.deleteRoomsById(id);

        return "redirect:/roomsManager";
    }


    @PostMapping("/deleteAllRooms")
    public String deleteAllProduct() {

        roomsManagerService.deleteAllRooms();

        return "redirect:/roomsManager";
    }
}