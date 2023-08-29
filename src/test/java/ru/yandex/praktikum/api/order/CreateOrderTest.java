package ru.yandex.praktikum.api.order;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.api.BaseTest;
import ru.yandex.praktikum.api.generators.OrderGenerator;
import ru.yandex.praktikum.api.pojo.Order;
import ru.yandex.praktikum.api.steps.OrderActions;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderTest extends BaseTest {
    @Parameterized.Parameter
    public String[] color;

    @Parameterized.Parameters
    public static Collection colourParams() {
        return Arrays.asList(
                new String[][] {{"BLACK"}},
                new String[][] {{"GREY"}},
                new String[][] {{"BLACK", "GREY"}},
                new String[][] {{}}
        );
    }
    @Test
    @DisplayName("Создание заказа с вариациями цвета самоката")
    public void checkCreateOrder() {
        OrderActions orderActions = new OrderActions();
        Order order = OrderGenerator.randomOrderWithScooterColorOptions(color);
        Response response = orderActions.createOrder(order);

        response.then().assertThat().body("track", notNullValue())
                .and()
                .statusCode(201);

        String track = response.path("track").toString();

        Response cancelResponse = orderActions.cancelOrder(track);
        cancelResponse.then().statusCode(200);
    }
}
