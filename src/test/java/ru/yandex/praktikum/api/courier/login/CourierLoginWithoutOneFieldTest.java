package ru.yandex.praktikum.api.courier.login;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.yandex.praktikum.api.BaseNegativeLoginTest;
import ru.yandex.praktikum.api.pojo.CourierCreds;

import static org.hamcrest.CoreMatchers.is;

public class CourierLoginWithoutOneFieldTest extends BaseNegativeLoginTest {
    @Test
    @DisplayName("Авторизация курьера без ввода логина")
    public void checkCourierLoginWithoutLogin() {
        courierActions.create(courier);
        Response response = courierActions.login(CourierCreds.takePasswordFrom(courier));
        response.then().assertThat().body("message", is("Недостаточно данных для входа"))
                .and()
                .statusCode(400);
    }
    @Test
    @DisplayName("Авторизация курьера без ввода пароля")
    public void checkCourierLoginWithoutPassword() {
        courierActions.create(courier);
        Response response = courierActions.login(CourierCreds.takeLoginFrom(courier));
        response.then().assertThat().body("message", is("Недостаточно данных для входа"))
                .and()
                .statusCode(400);
    }
}
