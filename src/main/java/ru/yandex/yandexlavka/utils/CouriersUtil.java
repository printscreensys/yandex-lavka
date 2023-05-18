package ru.yandex.yandexlavka.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.yandex.yandexlavka.model.Courier;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CouriersUtil {
    public enum CourierTypeEnum {
        FOOT("FOOT"), BIKE("BIKE"),  AUTO("AUTO");
        private String value;
        CourierTypeEnum(String value) {
            this.value = value;
        }
        @JsonValue
        public String getValue() {
            return value;
        }
        @Override
        public String toString() {
            return String.valueOf(value);
        }
        @JsonCreator
        public static CourierTypeEnum fromValue(String value) {
            for (CourierTypeEnum b : CourierTypeEnum.values()) {
                if (b.getValue().equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }
}
@Getter
@Setter
@Builder @AllArgsConstructor
class CourierWorkingHours {
    private int duration;
    private long courierId;
    private String courierType;
    private List<Integer> regions = new ArrayList<>();
}

