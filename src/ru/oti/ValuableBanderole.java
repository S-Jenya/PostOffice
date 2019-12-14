package ru.oti;

public class ValuableBanderole extends Box {

    public ValuableBanderole() {
        setValuation(true);
        setCountry("Россия");
        setTrackNumber();
        setMyFormat();
        setHandingOver();
    }

    @Override
    public void info(){
        System.out.println("Тип заказа: Ценная бандероль");
        System.out.println("Формат заказа: " + getMyFormat());
        System.out.println("Страна получателя: " + getCountry());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        System.out.println("Способ получения: " + getHandingOver());
        System.out.println("Трек номер: " + getTrackNumber());
        if(getValuation()){
            System.out.println("Объявленна ценность");
        }
        if(getSMSNotic()){
            System.out.println("Подключена услуга: \"SMS уведомление\"");
        }
        if(getDeliveryNotic()){
            System.out.println("Подключена услуга: \"Уведомление о вручении\"");
        }
        if(getCash()){
            System.out.println("Подключена услуга: \"Объявленная ценность\"");
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
