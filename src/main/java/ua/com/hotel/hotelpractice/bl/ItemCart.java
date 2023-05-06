package ua.com.hotel.hotelpractice.bl;

import lombok.*;
import ua.com.hotel.hotelpractice.entity.Rooms;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class ItemCart {
    private Rooms rooms;
}
