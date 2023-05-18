package ru.yandex.yandexlavka.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompleteOrder {
    private int courierId;
    private int orderId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private String completeTime;
}
