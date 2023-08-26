package ru.yandex.praktikum.api.courier.create;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.yandex.praktikum.api.BaseTest;
import ru.yandex.praktikum.api.generators.CourierGenerator;
import ru.yandex.praktikum.api.pojo.Courier;
import ru.yandex.praktikum.api.steps.CourierActions;

import static org.hamcrest.CoreMatchers.is;

public class CreateCourierWithoutLoginOrPasswordTest extends BaseTest {
    private CourierActions courierActions = new CourierActions();
    @Test
    @DisplayName("Создание курьера без логина")
    public void checkCreateCourierWithoutLogin() {
        Courier courier = CourierGenerator.randomCourierWithoutLogin();
        Response response = courierActions.create(courier);

        response.then().assertThat().body("message", is("Недостаточно данных для создания учетной записи"))
                .and()
                .statusCode(400);
    }
    @Test
    @DisplayName("Создание курьера без пароля")
    public void checkCreateCourierWithoutPassword() {
        Courier courier = CourierGenerator.randomCourierWithoutPassword();
        Response response = courierActions.create(courier);

        response.then().assertThat().body("message", is("Недостаточно данных для создания учетной записи"))
                .and()
                .statusCode(400);
    }
}
