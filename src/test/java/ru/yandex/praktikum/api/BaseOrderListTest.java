package ru.yandex.praktikum.api;

import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import ru.yandex.praktikum.api.generators.OrderGenerator;
import ru.yandex.praktikum.api.pojo.Order;
import ru.yandex.praktikum.api.steps.OrderActions;

import java.util.Random;

public class BaseOrderListTest extends BaseTest {
    protected OrderActions orderActions = new OrderActions();
    Random random = new Random();
    String[] tracks = new String[random.nextInt(15)];
    @Before
    public void createOrders() {
        for (int i = 0; i < tracks.length; i++) {
            Order order = OrderGenerator.randomOrderWithoutColor();
            Response response = orderActions.createOrder(order);
            tracks[i] = response.path("track").toString();
        }
    }
    @After
    public void cancelOrders() {
        for (String track : tracks) {
            Response response = orderActions.cancelOrder(track);
            response.then().statusCode(200);
        }
    }
}
