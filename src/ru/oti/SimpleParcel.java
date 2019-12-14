package ru.oti;

public class SimpleParcel extends Box {

    public SimpleParcel(){
        setMyFormat();
        setCountry();
        setTrackNumber();
        setDelivery(Delivery.ORDINARY_DELIVERY);
    }

    @Override
    public void info(){
        System.out.println("Тип заказа: Простая посылка");
        System.out.println("Формат заказа: " + getMyFormat());
        System.out.println("Страна получателя: " + getCountry());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        if(getCountry() == "Россия") {
            System.out.println("Способ получения: " + getHandingOver());
        }
        System.out.println("Трек номер: " + getTrackNumber());
        if(getSMSNotic()){
            System.out.println("Подключена услуга: \"SMS уведомление\"");
        }
        if(getDeliveryNotic()){
            System.out.println("Подключена услуга: \"Уведомление о вручении\"");
        }
        if(getValuation()){
            System.out.println("Подключена услуга: \"Объявленная ценность\"");
        }
        if(getCash()){
            System.out.println("Подключена услуга: \"Наложенный платеж\"");
        }
        if(getInventoryList()){
            System.out.println("Ваша опись вложения:");
            for (String s : inventoryList)
            {
                System.out.println("\t" + s);
            }
        }
    }
}
