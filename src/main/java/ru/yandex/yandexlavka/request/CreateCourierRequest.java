package ru.yandex.yandexlavka.request;

import lombok.*;
import ru.yandex.yandexlavka.dto.CreateCourierDto;
import ru.yandex.yandexlavka.dto.CreateOrderDto;

import java.util.List;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class CreateCourierRequest {
    private List<CreateCourierDto> couriers;
}

