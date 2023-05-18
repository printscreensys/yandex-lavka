package ru.yandex.yandexlavka.response;

import lombok.*;
import ru.yandex.yandexlavka.model.CouriersGroupOrders;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class OrderAssignResponse {
    private String date;
    private List<CouriersGroupOrders> couriers;
}
