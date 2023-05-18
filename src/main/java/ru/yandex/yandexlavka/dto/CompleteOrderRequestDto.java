package ru.yandex.yandexlavka.dto;

import lombok.*;
import ru.yandex.yandexlavka.model.CompleteOrder;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompleteOrderRequestDto {
    private CompleteOrder completeInfo;
}
