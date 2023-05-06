package ua.com.hotel.hotelpractice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 14, message = "Кількість символів повинна бути більша 2, але менша 14 символів")
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 2, max = 14, message = "Кількість символів повинна бути більша 2, але менша 14 символів")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Невірний email")
    private String email;

    @Min(value = 8, message = "Мінімальна кількість символів - 8")
    private int phone;

    @Min(value = 2, message = "Мінімальна кількість символів - 2")
    private int age;

    @OneToOne
    @MapKey
    @MapsId
    @JoinColumn(name = "id")
    private Users users;

    @OneToMany(mappedBy = "client")
    private List<Order> orderList;
}
