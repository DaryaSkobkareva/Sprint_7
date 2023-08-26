package ru.yandex.praktikum.api;

import io.restassured.response.Response;
import org.junit.After;
import ru.yandex.praktikum.api.pojo.Courier;
import ru.yandex.praktikum.api.steps.CourierActions;

public class BaseCourierTest extends BaseTest {
    protected String id;
    protected CourierActions courierActions = new CourierActions();
    protected Courier courier;
    @After
    public void tearsDown() {
        Response response = courierActions.delete(id);
        response.then().statusCode(200);
    }
}
