package ua.com.hotel.hotelpractice.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.hotel.hotelpractice.entity.Client;
import ua.com.hotel.hotelpractice.entity.Users;
import ua.com.hotel.hotelpractice.service.ClientManagerService;
import ua.com.hotel.hotelpractice.service.UserManagerService;

@Controller
public class UserManagerController {

    private final ClientManagerService clientManagerService;
    private final UserManagerService userService;

    @Autowired
    public UserManagerController(ClientManagerService clientManagerService, UserManagerService userService) {
        this.clientManagerService = clientManagerService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }


    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {

        model.addAttribute("users", new Users());
        model.addAttribute("client", new Client());

        return "/registration";
    }


    @PostMapping("/registration")
    public String saveNewClient(@Valid Users users,
                                BindingResult bindingResult,
                                @Valid Client client,
                                BindingResult bindingResult1,
                                Model model
    ) {

        if (bindingResult.hasErrors()) {
            return "/registration";
        }

        if (bindingResult1.hasErrors()) {
            return "/registration";
        }

        if (userService.getLogicByUser(users.getUsername())) {
            model.addAttribute("err", "Користувач з таким іменем вже існує!");
            return "/registration";
        }


        Users user1 = userService.saveNewUserToDB(users);

        client.setUsers(user1);

        clientManagerService.saveClientToDB(client);

        return "redirect:/login";
    }

    @GetMapping("/clientManager")
    public String getClientList(Model model) {

        model.addAttribute("client", userService.getRoomsList());

        return "/clientAdmin";
    }
}