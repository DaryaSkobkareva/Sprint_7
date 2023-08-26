package ru.yandex.praktikum.api;

import io.restassured.RestAssured;
import org.junit.Before;

import static ru.yandex.praktikum.api.configuration.BaseURI.BASE_URI;

public class BaseTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
    }
}
