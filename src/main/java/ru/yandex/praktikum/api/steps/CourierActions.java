package ru.yandex.praktikum.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.yandex.praktikum.api.pojo.Courier;
import ru.yandex.praktikum.api.pojo.CourierCreds;

import static io.restassured.RestAssured.given;
import static ru.yandex.praktikum.api.configuration.Endpoints.*;

public class CourierActions {
    @Step("Создание курьера")
    public Response create(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(CREATE_COURIER);
    }
    @Step("Авторизация курьера")
    public Response login(CourierCreds creds) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(creds)
                .when()
                .post(LOGIN_COURIER);
    }
    @Step("Удаление курьера")
    public Response delete(String id) {
        return given()
                .delete(DELETE_COURIER + id);
    }
}