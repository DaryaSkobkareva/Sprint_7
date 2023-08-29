package ru.yandex.praktikum.api;

import io.restassured.response.Response;
import org.junit.After;
import ru.yandex.praktikum.api.generators.CourierGenerator;
import ru.yandex.praktikum.api.pojo.Courier;
import ru.yandex.praktikum.api.pojo.CourierCreds;
import ru.yandex.praktikum.api.steps.CourierActions;

public class BaseNegativeLoginTest extends BaseTest {
    protected String id;
    protected CourierActions courierActions = new CourierActions();
    protected Courier courier = CourierGenerator.randomCourier();
    @After
    public void tearsDown() {
        Response correctCredsResponse = courierActions.login(CourierCreds.takeCredsFrom(courier));
        id = correctCredsResponse.path("id").toString();
        Response response = courierActions.delete(id);
        response.then().statusCode(200);
    }
}
