package ru.yandex.yandexlavka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.yandexlavka.dto.CompleteOrderRequestDto;
import ru.yandex.yandexlavka.dto.CreateOrderDto;
import ru.yandex.yandexlavka.dto.OrderDto;
import ru.yandex.yandexlavka.model.CouriersGroupOrders;
import ru.yandex.yandexlavka.model.GroupOrders;
import ru.yandex.yandexlavka.model.Order;
import ru.yandex.yandexlavka.request.CreateOrderRequest;
import ru.yandex.yandexlavka.response.OrderAssignResponse;
import ru.yandex.yandexlavka.service.CouriersGroupOrdersService;
import ru.yandex.yandexlavka.service.OrderService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CouriersGroupOrdersService couriersGroupOrdersService;

    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getOrders(@RequestParam(name = "limit", required = false, defaultValue = "1") Integer limit,
                                    @RequestParam(name = "offset", required = false, defaultValue = "0") Integer offset) {
        return orderService.findAll().subList(offset, limit).stream().map(Order::toDto).collect(Collectors.toList());
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        orderService.saveAll(createOrderRequest.getOrders().stream().map(CreateOrderDto::toOrder).collect(Collectors.toList()));
        return createOrderRequest.getOrders().stream().map(CreateOrderDto::toOrderDto).collect(Collectors.toList());
    }

    @PostMapping("/orders/complete")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> completeOrder(@RequestBody CompleteOrderRequestDto completeOrderRequestDto) {
        return null; //TODO
    }

    @GetMapping("/orders/{order_id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrder(@RequestParam long orderId) {
        return orderService.findByOrderId(orderId);
    }

    @PostMapping("/orders/assign")
    @ResponseStatus(HttpStatus.CREATED)
    public List<OrderAssignResponse> orderAssign(@RequestParam(required = false) String date) {
        Set<Order> toAssign = orderService.findAll().stream().filter(o -> !o.isAssigned()).collect(Collectors.toSet());
        for(Order o: toAssign) {
            orderService.assign(o.getOrderId());
        }

//        List<CouriersGroupOrders> couriersGroupOrders = couriersGroupOrdersService.findALl();
//        for(CouriersGroupOrders cgo:couriersGroupOrders) {
//            List<GroupOrders> groupOrders = cgo.getOrders();
//            for(GroupOrders go: groupOrders) {
//                List<OrderDto> orders = go.getOrders();
//                for(OrderDto orderDto: orders) {
//                    Order order = orderDto.toOrder();
//                    if ()
//                }
//            }
//        }


        return null;
    }
    //TODO Exception
}
