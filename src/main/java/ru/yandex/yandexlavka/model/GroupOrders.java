package ru.yandex.yandexlavka.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import lombok.*;
import ru.yandex.yandexlavka.dto.OrderDto;

import java.util.List;

@Entity
@Table(name = "GROUPORDERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GroupOrders {
    @Id
    @Column(name = "GROUP_COURIER_ID") @GeneratedValue(strategy = GenerationType.IDENTITY)
    long groupCourierId;
    @Column(name = "orders")
    List<OrderDto> orders;
}
