package ru.yandex.praktikum.api.generators;

import io.qameta.allure.Step;
import ru.yandex.praktikum.api.pojo.Courier;

import static ru.yandex.praktikum.api.utils.Utils.randomString;

public class CourierGenerator {
    @Step("Генерация курьера")
    public static Courier randomCourier() {
        return new Courier()
                .withLogin(randomString(8))
                .withPassword(randomString(6))
                .withFirstName(randomString(10));
    }
    @Step("Генерация курьера без имени")
    public static Courier randomCourierWithoutFirstName() {
        return new Courier()
                .withLogin(randomString(8))
                .withPassword(randomString(6));
    }
    @Step("Генерация курьера без логина")
    public static Courier randomCourierWithoutLogin() {
        return new Courier()
                .withPassword(randomString(6))
                .withFirstName(randomString(10));
    }
    @Step("Генерация курьера без пароля")
    public static Courier randomCourierWithoutPassword() {
        return new Courier()
                .withLogin(randomString(8))
                .withFirstName(randomString(10));
    }
}