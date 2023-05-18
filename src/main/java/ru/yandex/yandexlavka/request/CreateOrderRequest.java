package ru.yandex.yandexlavka.request;

import lombok.*;
import ru.yandex.yandexlavka.dto.CreateOrderDto;

import java.util.List;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class CreateOrderRequest {
    private List<CreateOrderDto> orders;
}
