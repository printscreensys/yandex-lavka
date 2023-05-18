package ru.yandex.yandexlavka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import ru.yandex.yandexlavka.model.Order;
import ru.yandex.yandexlavka.repository.OrderRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    OrderService(OrderRepository orderRepository) {
        this.orderRepository=orderRepository;
    }

    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    public void saveAll(Collection<Order> orders) {
        orderRepository.saveAll(orders);
    }

    public Order findByOrderId(long orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    public void assign(long orderId) {
        orderRepository.findByOrderId(orderId).setAssigned(true);
    }
}
