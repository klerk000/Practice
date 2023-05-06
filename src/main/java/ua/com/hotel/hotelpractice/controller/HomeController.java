package ua.com.hotel.hotelpractice.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.hotel.hotelpractice.bl.Search;
import ua.com.hotel.hotelpractice.entity.Category;
import ua.com.hotel.hotelpractice.entity.Rooms;
import ua.com.hotel.hotelpractice.entity.Users;
import ua.com.hotel.hotelpractice.service.CategoryService;
import ua.com.hotel.hotelpractice.service.ClientManagerService;
import ua.com.hotel.hotelpractice.service.RoomsService;
import ua.com.hotel.hotelpractice.service.UserManagerService;

import java.util.List;

@Controller
public class HomeController {
    private final UserManagerService userManagerService;
    private final ClientManagerService clientManagerService;
    private final CategoryService categoryService;
    private final RoomsService roomsService;


    public HomeController(UserManagerService userManagerService, ClientManagerService clientManagerService, CategoryService categoryService, RoomsService roomsService) {
        this.userManagerService = userManagerService;
        this.clientManagerService = clientManagerService;
        this.categoryService = categoryService;
        this.roomsService = roomsService;
    }

    @GetMapping("/")
    public String getPageHome(Model model) {
        model.addAttribute("hello", "Доброго ранку/дня/вечора/ночі шановний гість. " +
                "На цьому сайті ви можете вибрати потрібну категорію. " +
                "Та обрати вподобану кімнату зі списку. Дякуємо, що обрали нас!");
        return "home";
    }

    @GetMapping("/address")
    public String getAddress(Model model) {

        model.addAttribute("address",
                "Маліновського 7-101010100, " +
                        "Фіовського 5-10100101, " +
                        "Кранського 6-10101010, " +
                        "Абрамовського 9, " +
                        "Героїв Каморів 6");
        return "address";
    }

    @GetMapping("/client")
    public String currentUser(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Users users = userManagerService.loadUserByUsername(authentication.getName());

        model.addAttribute("client", clientManagerService.getClientById(users.getId()));
        return "/client";
    }

    @PostMapping("/result")
    public String search(@RequestParam("search-input") String value,
                         Model model,
                         HttpServletRequest request) {

        HttpSession session = request.getSession();
        Search search = (Search) session.getAttribute("result");

        List<Category> categoryList;
        List<Rooms> roomsList;

        if (search == null) {
            search = new Search();
        }

        categoryList = categoryService.getAllCategoryByName(value);
        roomsList = roomsService.getAllRoomsByName(value);

        if (categoryList.isEmpty() & roomsList.isEmpty()) {

            model.addAttribute("args", false);

        } else {
            search.setRoomsList(roomsList);
            search.setCategoryList(categoryList);
            model.addAttribute("args", true);
            session.setAttribute("result", search);
        }

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("roomsList", roomsList);

        return "/result";
    }

    @GetMapping("/result")
    public String getPageResult(HttpServletRequest request,
                                Model model) {

        Search search = (Search) request.getSession().getAttribute("result");

        List<Category> categoryList;
        List<Rooms> roomsList;

        if (search == null) {
            model.addAttribute("args", false);

        } else {
            model.addAttribute("args", true);
            categoryList = search.getCategoryList();
            roomsList = search.getRoomsList();
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("roomsList", roomsList);
        }

        return "/result";
    }
}