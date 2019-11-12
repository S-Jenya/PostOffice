package ru.oti;

public enum HandingOver {
    POSTMAN("Почтальон"),
    COURIER("Курьер");

    public String name;

    HandingOver(String s) {
        this.name = s;
    }

    public String getName(){
        return name;
    }
}
