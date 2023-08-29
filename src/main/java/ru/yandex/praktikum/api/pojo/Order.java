package ru.yandex.praktikum.api.pojo;

import io.qameta.allure.Step;

public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private String rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;
    public Order() {
    }
    @Step("Имя ззаказчика")
    public Order withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    @Step("Фамилия заказчика")
    public Order withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    @Step("Адрес заказчика")
    public Order withAddress(String address) {
        this.address = address;
        return this;
    }
    @Step("Станция метро")
    public Order withMetroStation(String metroStation) {
        this.metroStation = metroStation;
        return this;
    }
    @Step("Телефон заказчика")
    public Order withPhone(String phone) {
        this.phone = phone;
        return this;
    }
    @Step("Срок аренды")
    public Order withRentTime(String rentTime) {
        this.rentTime = rentTime;
        return this;
    }
    @Step("Дата доставки")
    public Order withDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }
    @Step("Комментарий")
    public Order withComment(String comment) {
        this.comment = comment;
        return this;
    }
    @Step("Цвет самоката")
    public Order withColor(String[] color) {
        this.color = color;
        return this;
    }
}
