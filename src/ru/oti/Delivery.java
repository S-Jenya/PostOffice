package ru.oti;

public enum Delivery {
    TRAIN("Поезд"),
    AIR("Самолёт"),
    SEA("Море"),
    PERSONALLY_COURIER("Лично курьер");

    public String name;

    Delivery(String s) {
        this.name = s;
    }

    public String getName(){
        return name;
    }
}
