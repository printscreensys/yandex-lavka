package ru.yandex.yandexlavka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ru.yandex.yandexlavka.dto.*;
import ru.yandex.yandexlavka.model.*;
import ru.yandex.yandexlavka.request.*;
import ru.yandex.yandexlavka.response.*;
import ru.yandex.yandexlavka.service.*;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class CourierController {
    @Autowired
    private CourierService courierService;

    @GetMapping("/couriers")
    @ResponseStatus(HttpStatus.OK)
    public GetCouriersResponse getCouriers(@RequestParam(name = "limit", required = false, defaultValue = "1") Integer limit,
                                      @RequestParam(name = "offset", required = false, defaultValue = "0") Integer offset) {
        List<CourierDto> sublist = courierService.findAll().subList(offset, limit).stream().map(Courier::toDto).toList();

        return new GetCouriersResponse(sublist, limit, offset);
    }

    @PostMapping("/couriers")
    @ResponseStatus(HttpStatus.OK)
    public CreateCouriersResponse createCourier(@RequestBody CreateCourierRequest createCourierRequest) {
        System.out.println("JOPA " + createCourierRequest.getCouriers().get(0).getCourierType());
        courierService.saveAll(createCourierRequest.getCouriers().stream().map(CreateCourierDto::toCourier).collect(Collectors.toList()));
        List<CourierDto> list = createCourierRequest.getCouriers().stream().map(CreateCourierDto::toCourierDto).collect(Collectors.toList());
        return new CreateCouriersResponse(list);
    }

    @GetMapping("/couriers/{courier_id}")
    @ResponseStatus(HttpStatus.OK)
    public CourierDto getCourier(@RequestParam long courierId) {
        return courierService.findByCourierId(courierId).toDto();
    }

    @GetMapping("couriers/meta-info/{courier_id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCourierMetaInfoResponse getCourierMetaInfo(@RequestParam long courierId,
                                                         @RequestParam String startDate,
                                                         @RequestParam String endDate) {
        Courier courier = courierService.findByCourierId(courierId);
        String courierType = courier.getCourierType();
        List<Integer> regions = courier.getRegions();
        List<String> workingHours = courier.getWorkingHours();
        if (Objects.equals(courierType, "FOOT")) {int C = 2;}
        if (Objects.equals(courierType, "BIKE")) {int C = 3;}
        if (Objects.equals(courierType, "AUTO")) {int C = 4;}
        //TODO sum costs
        GetCourierMetaInfoResponse resp = new GetCourierMetaInfoResponse(courierId,
                null,
                null, List.of(startDate, endDate), 0, 0);
        return null;
    }
}
