package ru.yandex.praktikum.api.utils;

import java.util.Random;

public class Utils {
    public static String randomString(int length) {
        Random random = new Random();
        int leftLimit = 97;
        int rightLimit = 122;
        StringBuilder buffer = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (float) (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
    public static String randomMetroStation() {
        Random random = new Random();
        int min = 1;
        int max = 215;
        int numberMetroStation = random.nextInt(max - min + 1) - min;
        return Integer.toString(numberMetroStation);
    }
    public static String randomRentTime() {
        Random random = new Random();
        int min = 1;
        int max = 7;
        int numberMetroStation = random.nextInt(max - min + 1) - min;
        return Integer.toString(numberMetroStation);
    }
    public static String randomPhone() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder();
        for (int i = 1; i < 11; i++) {
            int randomNumber = random.nextInt(10);
            String numberString = Integer.toString(randomNumber);
            phoneNumber.append(numberString);
        }
        return phoneNumber.toString();
    }
}
