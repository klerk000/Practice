package ua.com.hotel.hotelpractice.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.hotel.hotelpractice.bl.Cart;
import ua.com.hotel.hotelpractice.entity.Rooms;

@Controller
public class ItemCartController {

    @PostMapping("/cart")
    public String addNewItemToCart(@RequestParam(name = "id") Rooms rooms,
                                   HttpServletRequest request) {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.addNewItemToCart(rooms);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String getPageCart(HttpServletRequest request,
                              Model model) {

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        model.addAttribute("itemCart", cart.getCart());
        model.addAttribute("totalEl", cart.getTotalVal());

        return "cart";
    }

    @PostMapping("/deleteItem")
    public String deleteItemCart(@RequestParam(name = "id") Rooms rooms,
                                 HttpServletRequest request) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.deleteItem(rooms);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }
}