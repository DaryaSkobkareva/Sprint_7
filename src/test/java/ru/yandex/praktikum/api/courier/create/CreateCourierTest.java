package ru.yandex.praktikum.api.courier.create;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.yandex.praktikum.api.BaseCourierTest;
import ru.yandex.praktikum.api.generators.CourierGenerator;
import ru.yandex.praktikum.api.pojo.CourierCreds;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class CreateCourierTest extends BaseCourierTest {
    @Test
    @DisplayName("Создание курьера")
    public void checkCreateCourier() {
        courier = CourierGenerator.randomCourier();
        Response response = courierActions.create(courier);

        response.then().assertThat().body("ok", is(true))
                .and()
                .statusCode(201);

        Response loginResponse = courierActions.login(CourierCreds.takeCredsFrom(courier));
        id = loginResponse.path("id").toString();
        assertEquals("Некорректный логин / пароль", 200, loginResponse.statusCode());
    }
    @Test
    @DisplayName("Создание курьера без имени")
    public void checkCreateCourierWithoutFirstName() {
        courier = CourierGenerator.randomCourierWithoutFirstName();
        Response response = courierActions.create(courier);

        response.then().assertThat().body("ok", is(true))
                .and()
                .statusCode(201);

        Response loginResponse = courierActions.login(CourierCreds.takeCredsFrom(courier));
        id = loginResponse.path("id").toString();
        assertEquals("Некорректный логин / пароль", 200, loginResponse.statusCode());
    }
}
