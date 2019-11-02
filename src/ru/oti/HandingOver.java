package ru.oti;

public enum HandingOver {
    POSTMAN("Почтальон"),
    COURIER("Курьер");

    private String description;

    HandingOver(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
