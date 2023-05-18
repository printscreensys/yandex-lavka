package ru.yandex.yandexlavka.utils;

import ru.yandex.yandexlavka.dto.OrderDto;
import ru.yandex.yandexlavka.model.Courier;
import ru.yandex.yandexlavka.model.CouriersGroupOrders;
import ru.yandex.yandexlavka.model.Order;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.time.temporal.ChronoUnit.MINUTES;


public class OrdersUtil {
    public static List<CouriersGroupOrders> distribute(Collection<Order> orders, Collection<Courier> couriers) {
        final Map <String, Integer> maxWeights = Map.of("FOOT", 10, "BIKE", 20, "AUTO", 40);
        final Map <String, Integer> maxOrders = Map.of("FOOT", 2, "BIKE", 4, "AUTO", 7);
        final Map <String, Integer> maxRegions = Map.of("FOOT", 1, "BIKE", 2, "AUTO", 3);
        final Map <String, Integer> firstOrderInRegion = Map.of("FOOT", 25, "BIKE", 12, "AUTO", 8);
        final Map <String, Integer> nextOrdersInRegion = Map.of("FOOT", 10, "BIKE", 8, "AUTO", 4);
        final Map <String, Integer> firstOrderInOtherRegion = Map.of("BIKE", 12, "AUTO", 8);
        final Map <String, Integer> nextOrdersInOtherRegion = Map.of( "BIKE", 8, "AUTO", 4);
        final double firstOrderCost = 1;
        final double nextOrderCost = 0.8;

        Map<Integer, Integer> orderCourierMap = new HashMap<>();

        List<CourierWorkingHours> courierWorkingHours = new ArrayList<>();

        for(Courier c : couriers) {
            for(String w: c.getWorkingHours()) {
                String[] workingHours = w.split("-");
                String w1 = workingHours[0];
                String w2 = workingHours[1];
                LocalTime wTime1 = LocalTime.parse(w1, DateTimeFormatter.ofPattern("HH:mm:ss"));
                LocalTime wTime2 = LocalTime.parse(w2, DateTimeFormatter.ofPattern("HH:mm:ss"));
                courierWorkingHours.add(new CourierWorkingHours(
                        (int) MINUTES.between(wTime1, wTime2),
                        c.getCourierId(),
                        c.getCourierType(),
                        c.getRegions()
                ));
            }
        }

        courierWorkingHours = courierWorkingHours.stream().sorted(
                Comparator.comparing(CourierWorkingHours::getCourierType).
                        thenComparing(CourierWorkingHours :: getDuration).reversed()
                ).toList();

        Map<Integer, TreeSet<Order>> ordersRegionsMap = new HashMap<>();

        for (Order o: orders) {
            if (!ordersRegionsMap.containsKey(o.getRegions())){
                TreeSet<Order> entry = new TreeSet<>((new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        return (int) Math.signum(o1.getWeight() - o2.getWeight());
                    }
                }).reversed());
                ordersRegionsMap.put(o.getRegions(), entry);
            }
            else {
                TreeSet<Order> entry = ordersRegionsMap.get(o.getRegions());
                entry.add(o);
                ordersRegionsMap.put(o.getRegions(), entry);
            }
        }

        for(CourierWorkingHours cwh: courierWorkingHours) {
            List<OrderDto> ordersGroup = new ArrayList<>();
            float ordersGroupWeight = 0;
            int ordersGroupTime = 0;
            int regionsCount = 0;
            while (
                    ordersGroupWeight <= maxWeights.get(cwh.getCourierType())
                            && ordersGroupTime <= cwh.getDuration()
                            && regionsCount < maxRegions.get(cwh.getCourierType())) {
                float maxW = -1;
                for(int r: cwh.getRegions()) {
                    if (ordersRegionsMap.get(r).pollFirst().getWeight() > maxW) {
                        maxW = ordersRegionsMap.get(r).pollFirst().getWeight();
                        //TODO Continue
                    }
                }
            }
        }
        return null;
    };
}