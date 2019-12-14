package ru.oti;

public class OrderBanderoleFirstClass extends OrderedBanderole {

    public OrderBanderoleFirstClass(){
        super();
    }

    @Override
    public void info(){
        System.out.println("Тип заказа: Заказная бандероль 1 класса");
        System.out.println("Формат заказа: " + getMyFormat());
        System.out.println("Страна получателя: " + getCountry());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        System.out.println("Способ получения: " + getHandingOver());
        System.out.println("Трек номер: " + getTrackNumber());
        if(getSMSNotic()){
            System.out.println("Подключена услуга: \"SMS уведомление\"");
        }
        if(getDeliveryNotic()){
            System.out.println("Подключена услуга: \"Уведомление о вручении\"");
        }
        if(getCallDelivery()){
            System.out.println("Подключена услуга: \"Доставка по звонку\"");
        }
    }

}
