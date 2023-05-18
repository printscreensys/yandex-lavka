package ru.yandex.yandexlavka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.yandexlavka.model.Courier;
import ru.yandex.yandexlavka.model.Order;

import java.util.UUID;

public interface CourierRepository extends JpaRepository<Courier, UUID> {
    Courier findByCourierId(long courierId);
}
