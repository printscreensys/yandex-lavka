package ru.yandex.yandexlavka.service;

import org.springframework.stereotype.Service;
import ru.yandex.yandexlavka.model.CouriersGroupOrders;
import ru.yandex.yandexlavka.repository.CouriersGroupOrdersRepository;

import java.util.List;

@Service
public class CouriersGroupOrdersService {
    private final CouriersGroupOrdersRepository couriersGroupOrdersRepository;

    public CouriersGroupOrdersService(CouriersGroupOrdersRepository couriersGroupOrdersRepository) {
        this.couriersGroupOrdersRepository = couriersGroupOrdersRepository;
    }

    public List<CouriersGroupOrders> findALl() {
        return couriersGroupOrdersRepository.findAll();
    }
}
