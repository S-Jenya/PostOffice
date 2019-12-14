package ru.oti;

public class SimpleBanderole extends Box {

    public SimpleBanderole(){
        setCountry();
        setMyFormat();
    }

    @Override
    public void info(){
        System.out.println("Тип заказа: Простая бандероль");
        System.out.println("Формат заказа: " + getMyFormat());
        System.out.println("Страна получателя: " + getCountry());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        if(getCountry() == "Россия") {
            System.out.println("Способ получения: " + getHandingOver());
        }
    }

}
