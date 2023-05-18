package ru.yandex.yandexlavka.service;

import org.springframework.stereotype.Service;
import ru.yandex.yandexlavka.model.Courier;
import ru.yandex.yandexlavka.model.Order;
import ru.yandex.yandexlavka.repository.CourierRepository;
import ru.yandex.yandexlavka.repository.OrderRepository;

import java.util.Collection;
import java.util.List;

@Service
public class CourierService {
    private final CourierRepository courierRepository;

    CourierService(CourierRepository courierRepository) {
        this.courierRepository=courierRepository;
    }

    public List<Courier> findAll() {
        return courierRepository.findAll();
    }

    public void saveAll(Collection<Courier> couriers) {
        courierRepository.saveAll(couriers);
    }

    public Courier findByCourierId(long courierId) {
        return courierRepository.findByCourierId(courierId);
    }
}
