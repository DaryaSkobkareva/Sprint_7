package ru.yandex.praktikum.api.pojo;

import io.qameta.allure.Step;

import static ru.yandex.praktikum.api.utils.Utils.randomString;

public class CourierCreds {
    private String login;
    private String password;

    public CourierCreds(String login, String password) {
        this.login = login;
        this.password = password;
    }
    @Step("Получение корректных кредов курьера")
    public static CourierCreds takeCredsFrom(Courier courier) {
        return new CourierCreds(courier.getLogin(), courier.getPassword());
    }
    @Step("Получение логина курьера")
    public static CourierCreds takeLoginFrom(Courier courier) {
        return new CourierCreds(courier.getLogin(), "");
    }
    @Step("Получение пароля курьера")
    public static CourierCreds takePasswordFrom(Courier courier) {
        return new CourierCreds("", courier.getPassword());
    }
    @Step("Получение некорректного логина курьера")
    public static CourierCreds takeCredsWithInvalidLoginFrom(Courier courier) {
        String invalidLogin = randomString(6);
        return new CourierCreds(invalidLogin, courier.getPassword());
    }
    @Step("Получение некорректного пароля курьера")
    public static CourierCreds takeCredsWithInvalidPasswordFrom(Courier courier) {
        String invalidPassword = randomString(6);
        return new CourierCreds(courier.getLogin(), invalidPassword);
    }
    @Step("Получение некорректных кредов курьера")
    public static CourierCreds takeInvalidCreds() {
        String invalidLogin = randomString(6);
        String invalidPassword = randomString(6);
        return new CourierCreds(invalidLogin, invalidPassword);
    }
}
