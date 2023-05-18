package ru.yandex.yandexlavka.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;
import ru.yandex.yandexlavka.dto.CourierDto;
import ru.yandex.yandexlavka.model.Courier;
import ru.yandex.yandexlavka.utils.CouriersUtil.CourierTypeEnum;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Builder @Getter @Setter
public class GetCourierMetaInfoResponse {
    private long courierId;
    private CourierTypeEnum courierType;
    private List<Integer> regions = new ArrayList<>();
    private List<String> workingHours = new ArrayList<>();
    private int rating;
    private int earnings;
}
