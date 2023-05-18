package ru.yandex.yandexlavka.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.yandexlavka.model.Courier;
import ru.yandex.yandexlavka.utils.CouriersUtil.CourierTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter @Setter
public class CreateCourierDto {
    @JsonProperty("courier_type")
    private CourierTypeEnum courierType;
    private List<Integer> regions = new ArrayList<>();
    private List<String> workingHours = new ArrayList<>();

    public Courier toCourier() {
        Courier courier = new Courier();
        courier.setCourierType(courierType.getValue());
        courier.setRegions(regions);
        courier.setWorkingHours(workingHours);
        return courier;
    }
    public CourierDto toCourierDto() {
        return this.toCourier().toDto();
    }
}