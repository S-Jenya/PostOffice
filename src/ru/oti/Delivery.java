package ru.oti;

public enum Delivery {
    ORDINARY_DELIVERY("Обычная доставка"),
    AIR("Самолёт"),
    PERSONALLY_COURIER("Лично курьер");

    public String name;

    Delivery(String s) {
        this.name = s;
    }

    public String getName(){
        return name;
    }
}
