package ru.yandex.praktikum.api.order;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.yandex.praktikum.api.BaseOrderListTest;

import static org.hamcrest.CoreMatchers.notNullValue;

public class GetOrderListTest extends BaseOrderListTest {
    @Test
    @DisplayName("Получение списка заказов")
    public void checkGetOrderList() {
        Response response = orderActions.getFullOrderList();

        response.then().assertThat().body("orders", notNullValue())
                .and()
                .statusCode(200);
    }
}
