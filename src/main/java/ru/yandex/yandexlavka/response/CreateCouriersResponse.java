package ru.yandex.yandexlavka.response;

import lombok.*;
import ru.yandex.yandexlavka.dto.CourierDto;
import ru.yandex.yandexlavka.dto.CreateCourierDto;
import ru.yandex.yandexlavka.dto.CreateOrderDto;

import java.util.List;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCouriersResponse {
    private List<CourierDto> couriers;
}
