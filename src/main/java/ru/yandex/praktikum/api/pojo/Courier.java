package ru.yandex.praktikum.api.pojo;

import io.qameta.allure.Step;

public class Courier {
    private String login;
    private String password;
    private String firstName;

    public Courier() {
    }
    @Step("Логин курьера")
    public Courier withLogin(String login) {
        this.login = login;
        return this;
    }
    @Step("Пароль курьера")
    public Courier withPassword(String password) {
        this.password = password;
        return this;
    }
    @Step("Имя курьера")
    public Courier withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    @Step("Получение логина курьера")
    public String getLogin() {
        return login;
    }
    @Step("Получение пароля курьера")
    public String getPassword() {
        return password;
    }
}
