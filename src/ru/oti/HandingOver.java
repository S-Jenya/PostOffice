package ru.oti;

public enum HandingOver {
    PERSONALLY("Получить лично в почтовом отделении"),
    ATTORNEY_IN_FACT("Представитель по доверенности"),
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
