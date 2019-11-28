package ru.oti;

public interface Letter {

    // тип отправки
    void info();

    // установка формата письма
    void setMyFormat(MyFormat myFormat);
    String getMyFormat();

    // способы доставки
    void setDeliveryMethod();
    String getDeliveryMethod();

    // способы получения
    void setHandingOver();
    String getHandingOver();

    // трек номер
    void setTrackNumber();
    // уведомление о вручении
    void deliveryNotice();
    // СМС-уведомление содержит трек-номер отправления и статус доставки.
    void SMSNotification();
    // услуга — «Доставка по звонку»
    void callDelivery();
    // объявленная ценность
    void setValuation(boolean valuation);
    // Опись вложения
    void inventoryOfContents();
    // наложенный платёж
    void cashOnDelivery(boolean cash);

}
