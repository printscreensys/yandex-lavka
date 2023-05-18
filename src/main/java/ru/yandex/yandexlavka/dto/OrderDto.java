package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.yandex.yandexlavka.model.Order;

import java.util.*;
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class OrderDto {
    private Long orderId;
    private Float weight;
    private Integer regions;
    private List<String> deliveryHours = new ArrayList<>();
    private Integer cost;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private String completedTime;

    public OrderDto(Long orderId, Float weight, Integer regions, List<String> deliveryHours, Integer cost) {
        this.orderId = orderId;
        this.weight = weight;
        this.regions = regions;
        this.deliveryHours = deliveryHours;
        this.cost = cost;
    }


    public Order toOrder() {return new Order(orderId, weight, regions, deliveryHours, cost, completedTime);}

}

