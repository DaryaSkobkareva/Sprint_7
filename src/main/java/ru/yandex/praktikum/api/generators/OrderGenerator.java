package ru.yandex.praktikum.api.generators;

import io.qameta.allure.Step;
import ru.yandex.praktikum.api.pojo.Order;

import java.time.LocalDate;

import static ru.yandex.praktikum.api.utils.Utils.*;
import static ru.yandex.praktikum.api.utils.Utils.randomString;

public class OrderGenerator {
    @Step("Генерация заказа")
    public static Order randomOrderWithScooterColorOptions(String[] color) {
        LocalDate today = LocalDate.now();
        return new Order()
                .withFirstName(randomString(6))
                .withLastName(randomString(9))
                .withAddress(randomString(25))
                .withMetroStation(randomMetroStation())
                .withPhone("+7" + randomPhone())
                .withRentTime(randomRentTime())
                .withDeliveryDate(today.toString())
                .withComment(randomString(38))
                .withColor(color);
    }
    @Step("Генерация заказа без цвета самоката")
    public static Order randomOrderWithoutColor() {
        LocalDate today = LocalDate.now();
        return new Order()
                .withFirstName(randomString(6))
                .withLastName(randomString(9))
                .withAddress(randomString(25))
                .withMetroStation(randomMetroStation())
                .withPhone("+7" + randomPhone())
                .withRentTime(randomRentTime())
                .withDeliveryDate(today.toString())
                .withComment(randomString(38));
    }
}
