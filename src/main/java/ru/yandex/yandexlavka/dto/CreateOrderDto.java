package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Entity;
import lombok.*;
import ru.yandex.yandexlavka.model.Order;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class CreateOrderDto {
    private float weight;
    private int regions;
    private List<String> deliveryHours;
    private int cost;

    public Order toOrder() {
        Order order = new Order();
        order.setWeight(weight);
        order.setRegions(regions);
        order.setCost(cost);
        order.setDeliveryHours(deliveryHours);
        return order; //TODO какие ID и completedTime
    }
    public OrderDto toOrderDto() {
        return this.toOrder().toDto(); //TODO какие ID и completedTime
    }

}
