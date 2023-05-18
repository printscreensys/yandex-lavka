package ru.yandex.yandexlavka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.yandexlavka.model.CouriersGroupOrders;
import ru.yandex.yandexlavka.model.Order;

import java.util.UUID;

public interface CouriersGroupOrdersRepository extends JpaRepository<CouriersGroupOrders, UUID> {
}
