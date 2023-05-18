package ru.yandex.yandexlavka.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.yandex.yandexlavka.dto.OrderDto;

import java.util.*;
@Entity @Table(name = "ORDERS")
@Getter @Setter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Order {
    @Id @Column(name = "ORDER_ID") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    @Column(name = "WEIGHT")
    private float weight;
    @Column(name = "REGIONS")
    private int regions;
    @Column(name = "DELIVERYHOURS")
    private List<String> deliveryHours = new ArrayList<>();
    @Column(name = "COST")
    private int cost;
    @Column(name = "COMPLETEDTIME")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private String completedTime;
    @Column(name = "ASSIGNED")
    private boolean assigned;
    @Column(name = "COURIER_ID")
    private long courierId;

    @Builder
    public Order(Long orderId, Float weight, Integer regions, List<String> deliveryHours, Integer cost, String completedTime) {
        this.orderId = orderId;
        this.weight = weight;
        this.regions = regions;
        this.deliveryHours = deliveryHours;
        this.cost = cost;
        this.completedTime = completedTime;
    }
    @Builder
    public Order(Long orderId, Float weight, Integer regions, List<String> deliveryHours, Integer cost) {
        this.orderId = orderId;
        this.weight = weight;
        this.regions = regions;
        this.deliveryHours = deliveryHours;
        this.cost = cost;
    }

    public OrderDto toDto() {
        return new OrderDto(orderId, weight, regions, deliveryHours, cost, completedTime);
    }
}
