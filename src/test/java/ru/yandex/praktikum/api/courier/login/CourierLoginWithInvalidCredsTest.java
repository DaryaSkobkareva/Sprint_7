package ru.yandex.praktikum.api.courier.login;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import ru.yandex.praktikum.api.BaseNegativeLoginTest;
import ru.yandex.praktikum.api.pojo.CourierCreds;

import static org.hamcrest.CoreMatchers.is;

public class CourierLoginWithInvalidCredsTest extends BaseNegativeLoginTest {
    @Test
    @DisplayName("Авторизация несуществующего курьера")
    public void checkCourierLoginWithInvalidCreds() {
        courierActions.create(courier);
        Response response = courierActions.login(CourierCreds.takeInvalidCreds());
        response.then().assertThat().body("message", is("Учетная запись не найдена"))
                .and()
                .statusCode(404);
    }
    @Test
    @DisplayName("Авторизация курьера с некорректным логином")
    public void checkCourierLoginWithInvalidLogin() {
        courierActions.create(courier);
        Response response = courierActions.login(CourierCreds.takeCredsWithInvalidLoginFrom(courier));
        response.then().assertThat().body("message", is("Учетная запись не найдена"))
                .and()
                .statusCode(404);
    }
    @Test
    @DisplayName("Авторизация курьера с некоррекным паролем")
    public void checkCourierLoginWithInvalidPassword() {
        courierActions.create(courier);
        Response response = courierActions.login(CourierCreds.takeCredsWithInvalidPasswordFrom(courier));
        response.then().assertThat().body("message", is("Учетная запись не найдена"))
                .and()
                .statusCode(404);
    }
}
