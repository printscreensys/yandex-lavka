package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Entity;
import lombok.*;
import ru.yandex.yandexlavka.model.Courier;
import ru.yandex.yandexlavka.utils.CouriersUtil.CourierTypeEnum;

import java.util.ArrayList;
import java.util.List;

//@Table(name = "ORDER")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CourierDto {
    private Long courierId;
    @JsonProperty("courier_type")
    private CourierTypeEnum courierType;
    private List<Integer> regions = new ArrayList<>();
    private List<String> workingHours = new ArrayList<>();
    
    Courier toCourier() {return new Courier(courierId, courierType.getValue(), regions, workingHours);}
}
