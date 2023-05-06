package ua.com.hotel.hotelpractice.bl;

import lombok.Getter;
import lombok.Setter;
import ua.com.hotel.hotelpractice.entity.Rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Cart {
    List<ItemCart> cart;

    private Double totalValue;
    private int sumItem;

    public Cart() {
        cart = new ArrayList<>();

        sumItem = 0;
    }

    public synchronized void addNewItemToCart(Rooms rooms) {

        boolean logic = true;

        for (ItemCart el : cart) {
            if (Objects.equals(rooms.getId(), el.getRooms().getId())) {
                logic = false;
                break;
            }
        }

        if (logic) {
            cart.add(new ItemCart(rooms));
        }
    }

    public synchronized void deleteItem(Rooms rooms) {
        for (ItemCart el : cart) {
            if (el.getRooms().getId().equals(rooms.getId())) {
                cart.remove(el);
                break;
            }
        }
    }

    public synchronized Double getTotalVal() {

        totalValue = 0.0;

        cart.forEach(el -> totalValue += el.getRooms().getPrice());
        return totalValue;
    }
}