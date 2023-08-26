package ru.yandex.praktikum.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.yandex.praktikum.api.pojo.Order;

import static io.restassured.RestAssured.given;
import static ru.yandex.praktikum.api.configuration.Endpoints.*;

public class OrderActions {
    @Step("Создание заказа")
    public Response createOrder(Order order) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(order)
                .when()
                .post(CREATE_ORDER);
    }
    @Step("Получение полного списка заказов")
    public Response getFullOrderList() {
        return given()
                .when()
                .get(ORDERS_LIST);
    }
    @Step("Отмена заказа")
    public Response cancelOrder(String track) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(track)
                .when()
                .put(CANCEL_ORDER);
    }
}
