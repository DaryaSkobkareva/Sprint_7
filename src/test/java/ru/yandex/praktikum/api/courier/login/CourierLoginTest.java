package ru.yandex.praktikum.api.courier.login;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.yandex.praktikum.api.BaseCourierTest;
import ru.yandex.praktikum.api.generators.CourierGenerator;
import ru.yandex.praktikum.api.pojo.CourierCreds;

import static org.hamcrest.CoreMatchers.notNullValue;

public class CourierLoginTest extends BaseCourierTest {
    @Test
    @DisplayName("Авторизация курьера")
    public void checkCourierLogin() {
        courier = CourierGenerator.randomCourier();
        courierActions.create(courier);

        Response response = courierActions.login(CourierCreds.takeCredsFrom(courier));
        response.then().assertThat().body("id", notNullValue())
                .and()
                .statusCode(200);

        id = response.path("id").toString();
    }
}
