package ru.oti;

public class OrderedLetterFirstClass extends OrderedLetter {

    public OrderedLetterFirstClass(){
        super();
    }

    @Override
    public void info(){
        System.out.println("Тип заказа: Заказное письмо 1 класса");
        System.out.println("Страна получателя: " + getCountry());
        System.out.println("Формат заказа: " + getMyFormat());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        System.out.println("Способ получения: " + getHandingOver());
        System.out.println("Трек номер: " + getTrackNumber());
        if(getDeliveryNotic()){
            System.out.println("Подключена услуга: \"Уведомление о вручении\"");
        }
        if(getCallDelivery()){
            System.out.println("Подключена услуга: \"Доставка по звонку\"");
        }
        if(getSMSNotic()){
            System.out.println("Подключена услуга: \"SMS уведомление\"");
        }
    }

}
