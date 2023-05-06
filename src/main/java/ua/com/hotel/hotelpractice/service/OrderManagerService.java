package ua.com.hotel.hotelpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hotel.hotelpractice.entity.Order;
import ua.com.hotel.hotelpractice.repository.OrderRepository;

import java.util.List;

@Service
public class OrderManagerService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderManagerService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findListOrderByStatus(boolean status) {
        return orderRepository.findByStatusOrder(status);
    }

    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }


    public void updateOrderNewStatus(Order order) {

        order.setStatusOrder(!order.isStatusOrder());

        orderRepository.save(order);
    }
}