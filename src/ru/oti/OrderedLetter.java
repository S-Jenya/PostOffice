package ru.oti;

public class OrderedLetter extends Letter {

    public OrderedLetter(){
        setMyFormat();
        setTrackNumber();
    }

    @Override
    public void info(){
        System.out.println("Тип заказа: Заказное письмо");
        System.out.println("Страна получателя: " + getCountry());
        System.out.println("Формат заказа: " + getMyFormat());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        if(getCountry() == "Россия") {
            System.out.println("Способ получения: " + getHandingOver());
        }
        System.out.println("Трек номер: " + getTrackNumber());
        if(getDeliveryNotic()){
            System.out.println("Подключена услуга: \"Уведомление о вручении\"");
        }
        if(getSMSNotic()){
            System.out.println("Подключена услуга: \"SMS уведомление\"");
        }
    }

}
