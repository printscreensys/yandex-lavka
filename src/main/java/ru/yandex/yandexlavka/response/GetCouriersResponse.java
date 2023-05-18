package ru.yandex.yandexlavka.response;

import lombok.*;
import ru.yandex.yandexlavka.dto.CourierDto;

import java.util.List;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCouriersResponse {
    private List<CourierDto> couriers;
    private int limit;
    private int offset;
}
