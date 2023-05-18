package ru.yandex.yandexlavka.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import lombok.*;
import ru.yandex.yandexlavka.dto.CourierDto;
import ru.yandex.yandexlavka.utils.CouriersUtil.CourierTypeEnum;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "Couriers")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Courier {
    @Id @Column(name = "COURIER_ID") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courierId;
    @Column(name = "COURIER_TYPE")
    private String courierType;
    @Column(name = "REGIONS")
    private List<Integer> regions = new ArrayList<>();
    @Column(name = "WORKING_HOURS")
    private List<String> workingHours = new ArrayList<>();

    public CourierDto toDto() {
        return new CourierDto(courierId, CourierTypeEnum.fromValue(courierType), regions, workingHours);
    }
}
