package ru.oti;

public interface Letter {
    // установка формата письма
    void setMyFormat(MyFormat myFormat);
    MyFormat getMyFormat();

    // способы доставки
    void setDeliveryMethod(Delivery delivery);
    Delivery getDeliveryMethod();

    // способы получения
    void setHandingOver(HandingOver handingOver);
    HandingOver getHandingOver();
}
