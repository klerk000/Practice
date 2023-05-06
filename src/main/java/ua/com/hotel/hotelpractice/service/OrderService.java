package ua.com.hotel.hotelpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hotel.hotelpractice.bl.Cart;
import ua.com.hotel.hotelpractice.bl.ItemCart;
import ua.com.hotel.hotelpractice.entity.Client;
import ua.com.hotel.hotelpractice.entity.Order;
import ua.com.hotel.hotelpractice.entity.RoomsHasOrder;
import ua.com.hotel.hotelpractice.repository.OrderRepository;
import ua.com.hotel.hotelpractice.repository.RoomsHasOrderRepository;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final RoomsHasOrderRepository roomsHasOrderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, RoomsHasOrderRepository roomsHasOrderRepository) {
        this.orderRepository = orderRepository;
        this.roomsHasOrderRepository = roomsHasOrderRepository;
    }

    public List<Order> getAllOrdersByClient(Client client) {
        return orderRepository.getAllByClient(client);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public void saveOrderToDB(Client client, Cart cart, String payment) {

        Order order = new Order();
        order.setDataCreated(new Date());
        order.setPayment(payment);
        order.setStatusOrder(false);
        order.setClient(client);
        Order order1 = orderRepository.save(order);


        for (ItemCart el : cart.getCart()) {
            RoomsHasOrder roomsHasOrder = new RoomsHasOrder();
            roomsHasOrder.setRooms(el.getRooms());
            roomsHasOrder.setOrder(order1);
            roomsHasOrderRepository.save(roomsHasOrder);
        }
    }
}