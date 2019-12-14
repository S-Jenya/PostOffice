package ru.oti;

public class OrderedBanderole extends Box {

    public OrderedBanderole(){
        setMyFormat();
        setTrackNumber();
    }

    @Override
    public void info(){
        System.out.println("Тип заказа: Заказная бандероль");
        System.out.println("Формат заказа: " + getMyFormat());
        System.out.println("Страна получателя: " + getCountry());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        if(getCountry() == "Россия") {
            System.out.println("Способ получения: " + getHandingOver());
        }
        if(getDeliveryNotic()){
            System.out.println("Подключена услуга: \"Уведомление о вручении\"");
        }
        if(getSMSNotic()){
            System.out.println("Подключена услуга: \"SMS уведомление\"");
        }
    }

}
