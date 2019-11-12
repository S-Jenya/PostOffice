package ru.oti;

public interface Letter extends Parcel {

    // тип отправки
    void Title();

    // установка формата письма
    void setMyFormat(MyFormat myFormat);
    MyFormat getMyFormat();

    // способы доставки
    void setDeliveryMethod(Delivery delivery);
    Delivery getDeliveryMethod();

    // способы получения
    void setHandingOver(HandingOver handingOver);
    HandingOver getHandingOver();

    // трек номер
    void getTrackNumber();
    // уведомление о вручении
    void deliveryNotice();
    // СМС-уведомление содержит трек-номер отправления и статус доставки.
    void SMSNotification();
    // услуга — «Доставка по звонку»
    void callDelivery();
    // объявленная ценность
    void setValuation(int valuation);
    // Опись вложения
    void inventoryOfContents();
    // наложенный платёж
    void cashOnDelivery();
}
