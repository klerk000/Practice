package ua.com.hotel.hotelpractice.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "rooms_has_order")
public class RoomsHasOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rooms_id")
    private Rooms rooms;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private Order order;

    public RoomsHasOrder(Rooms rooms, Order order) {
        this.rooms = rooms;
        this.order = order;
    }
}