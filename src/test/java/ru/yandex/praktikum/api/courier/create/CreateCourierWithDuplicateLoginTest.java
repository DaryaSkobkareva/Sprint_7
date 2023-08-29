package ru.yandex.praktikum.api.courier.create;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;
import ru.yandex.praktikum.api.BaseCourierTest;
import ru.yandex.praktikum.api.generators.CourierGenerator;
import ru.yandex.praktikum.api.pojo.CourierCreds;

import static org.hamcrest.CoreMatchers.is;

public class CreateCourierWithDuplicateLoginTest extends BaseCourierTest {
    @Test
    @DisplayName("Создание курьеров с одинаковыми логинами")
    public void checkCreateCourierWithDuplicateLogin() {
        courier = CourierGenerator.randomCourier();
        courierActions.create(courier);
        Response response = courierActions.create(courier);

        response.then().assertThat().body("message", is("Этот логин уже используется"))
                .and()
                .statusCode(409);
    }
    @After
    @Override
    public void tearsDown() {
        Response correctCredsResponse = courierActions.login(CourierCreds.takeCredsFrom(courier));
        id = correctCredsResponse.path("id").toString();
        courierActions.delete(id);
    }
}
