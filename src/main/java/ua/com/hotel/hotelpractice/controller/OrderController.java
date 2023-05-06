package ua.com.hotel.hotelpractice.controller;


import org.springframework.security.core.Authentication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.hotel.hotelpractice.bl.Cart;
import ua.com.hotel.hotelpractice.entity.Client;
import ua.com.hotel.hotelpractice.entity.Order;
import ua.com.hotel.hotelpractice.service.ClientService;
import ua.com.hotel.hotelpractice.service.OrderService;
import ua.com.hotel.hotelpractice.service.UserManagerService;

import java.util.List;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final ClientService clientService;
    private final UserManagerService userManagerService;


    public OrderController(OrderService orderService, ClientService clientService, UserManagerService userManagerService) {
        this.orderService = orderService;
        this.clientService = clientService;
        this.userManagerService = userManagerService;
    }

    @GetMapping("/order")
    public String getPageOrder(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Client client = clientService.getClientByUser(userManagerService.loadUserByUsername(authentication.getName()));

        List<Order> orderList = orderService.getAllOrdersByClient(client);

        model.addAttribute("listOrder", orderList);

        return "order";
    }

    @PostMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("id") Long id,
                              HttpServletRequest request) {

        orderService.deleteOrderById(id);

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart.getCart().isEmpty()) {
            return "/category";
        }
        return "/order";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(HttpServletRequest request,
                            @RequestParam("payment") String payment) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) return "redirect:/category";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Client client = clientService.getClientByUser(userManagerService.loadUserByUsername(authentication.getName()));

        orderService.saveOrderToDB(client, cart, payment);

        return "/thanks";
    }

    @GetMapping("/thanks")
    public String thanks(){
        return "/thanks";
    }
}
