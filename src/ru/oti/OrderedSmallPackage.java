package ru.oti;

import java.util.Random;

public class OrderedSmallPackage extends SmallPackage {

    public OrderedSmallPackage(){
        super();
        setTrackNumber();
    }

    @Override
    public void info(){
        System.out.println("Тип заказа: Заказной мелкий пакет");
        System.out.println("Формат заказа: " + getMyFormat());
        System.out.println("Страна получателя: " + getCountry());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        if(getDeliveryNotic()){
            System.out.println("Подключена услуга: \"Уведомление о вручении\"");
        }
    }

}
