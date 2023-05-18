package ru.yandex.yandexlavka.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CouriersGroupOrders {
    long courierId;
    List<GroupOrders> orders;
}
