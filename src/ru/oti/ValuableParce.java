package ru.oti;

public class ValuableParce extends Box {

    public ValuableParce(){
        setTrackNumber();
        setMyFormat();
        setCountry();
        setDelivery(Delivery.ORDINARY_DELIVERY);
        setValuation(true);
    }

    @Override
    public void info(){
        System.out.println("Тип заказа: Ценная посылка");
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
